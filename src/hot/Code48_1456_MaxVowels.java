package hot;

/**
 * 1456. 定长子串中元音的最大数目
 */
public class Code48_1456_MaxVowels {

    public static void main(String[] args) {
        int maxVowels = maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33);
        System.out.println(maxVowels);
    }

    /**
     * 解题思路：
     * 1.初始化窗口内所有 元音字母
     * 2.当窗口向前移动时，判断前一位是否是元音字母，是则 -1，判断最后一位是否值元音字母，是则 +1
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k) {
        int[] ints = new int[128];
        ints['a'] = 1;
        ints['e'] = 1;
        ints['i'] = 1;
        ints['o'] = 1;
        ints['u'] = 1;
        int target = 0;
        int init = 0;
        if (s.length() == 0) {
            return target;
        }
        char[] chars = s.toCharArray();
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            if (ints[chars[i]] == 1) {
                init++;
            }
        }
        // 初始化 target
        target = init;
        for (int i = 1; i + k <= chars.length; i++) {
            // 判断前一位
            if (ints[chars[i - 1]] == 1) {
                init--;
            }
            // 判断后一位
            if (ints[chars[i + k - 1]] == 1) {
                init++;
            }
            if (init > target) {
                target = init;
            }
        }
        if (init > target) {
            target = init;
        }
        return target;
    }

    /**
     * 超过时间限制
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels1(String s, int k) {
        int[] ints = new int[128];
        ints['a'] = 1;
        ints['e'] = 1;
        ints['i'] = 1;
        ints['o'] = 1;
        ints['u'] = 1;
        int target = 0;
        if (s.length() == 0) {
            return target;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int sum = 0;
            int length = k;
            int x = i;
            while (length > 0) {
                if (x < chars.length && ints[chars[x]] == 1) {
                    sum++;
                }
                x++;
                length--;
            }
            if (target < sum) {
                target = sum;
            }
        }
        return target;
    }
}
