package hot;

public class Code49_1423_MaxScore {

    public static void main(String[] args) {
        int maxScore = maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println(maxScore);
    }

    /**
     * 解题思路：
     * 1.当 k > 数组长度时 直接返回数组所有和
     * 2.拼凑数组，组成一个可以完全当作固定长度的滑窗数组
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore(int[] cardPoints, int k) {
        int target = 0;
        if (cardPoints.length == 0) {
            return target;
        }
        // k > 数组长度 直接返回
        if (k >= cardPoints.length) {
            for (int i = 0; i < cardPoints.length; i++) {
                target = target + cardPoints[i];
            }
            return target;
        }
        int[] ints = new int[k * 2];
        int index = 0;
        // 数组开头反取
        for (int i = k - 1; i >= 0; i--) {
            ints[i] = cardPoints[index++];
        }
        index = k;
        // 数组结尾正取
        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
            ints[index++] = cardPoints[i];
        }
        int sum = 0;
        // 固定长度窗口遍历数组即可
        for (int i = 0; i < ints.length; i++) {
            if (i < k) {
                sum = sum + ints[i];
            } else {
                sum = sum + ints[i] - ints[i - k];
            }
            if (target < sum) {
                target = sum;
            }
        }
        return target;
    }

    /**
     * 超过时间限制
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public static int maxScore1(int[] cardPoints, int k) {
        int target = 0;
        if (cardPoints.length == 0) {
            return target;
        }
        if (k >= cardPoints.length) {
            for (int i = 0; i < cardPoints.length; i++) {
                target = target + cardPoints[i];
            }
            return target;
        }
        int[] ints = new int[k * 2];
        int index = 0;
        for (int i = k - 1; i >= 0; i--) {
            ints[i] = cardPoints[index++];
        }
        index = k;
        for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
            ints[index++] = cardPoints[i];
        }
        for (int i = 0; i + k <= ints.length; i++) {
            int sum = 0;
            for (int i1 = i; i1 < k + i; i1++) {
                sum = sum + ints[i1];
            }
            if (target < sum) {
                target = sum;
            }
        }
        return target;
    }
}
