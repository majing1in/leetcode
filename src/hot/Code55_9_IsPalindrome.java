package hot;

/**
 * @Author Xiaoma
 * @Date 2021/3/1 0001 23:05
 * @Email 1468835254@qq.com
 */
public class Code55_9_IsPalindrome {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
