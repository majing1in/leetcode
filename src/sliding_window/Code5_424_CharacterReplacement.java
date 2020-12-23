package sliding_window;

/**
 * 424. 替换后的最长重复字符
 */
public class Code5_424_CharacterReplacement {

    public static void main(String[] args) {
        int replacement = characterReplacement("AABBB", 1);
        System.out.println(replacement);
    }

    /**
     * 长度可变滑动窗口 难点：边界条件判断，左右两侧判断，如何结束
     * 边界条件：当count > 0 时，证明已经到头，如果数组左边有空间则 sum 加上剩余的 count
     *         当count < 0 时，已经达到了最长
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int target = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int count = k;
            char c = chars[i];
            int sum = 0;
            int index = i;
            while (index < chars.length) {
                if (c != chars[index]) {
                    count--;
                }
                if (count < 0) {
                    break;
                }
                sum++;
                index++;
            }
            if (count > 0) {
                // 左边剩下的多，并且没有达到数组长度，数组长度直接拉闸
                if (index > count && sum - chars.length != 0) {
                    // 左边加上剩下的比数组长，直接拉闸，否则加上count
                    if (sum + count > chars.length) {
                        sum = chars.length;
                    } else {
                        sum = sum + count;
                    }
                }
                // 左边剩余少时，直接加上index
                if (index < count){
                    sum = sum + index;
                }
            }
            if (sum > target) {
                target = sum;
            }
        }
        return target;
    }
}
