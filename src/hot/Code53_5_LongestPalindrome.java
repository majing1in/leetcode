package hot;

/**
 * @Author Xiaoma
 * @Date 2021/3/1 0001 21:52
 * @Email 1468835254@qq.com
 */
public class Code53_5_LongestPalindrome {

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        if (s.length() == 0) {
            return result;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        // 判断首尾是否相等
        while (start < chars.length) {
            int end = chars.length - 1;
            while (start < end) {
                if (chars[start] == chars[end]) {
                    boolean palindrome = isPalindrome(s.substring(start, end + 1), 0, end - start + 1);
                    if (palindrome) {
                        result = result.length() > (end - start + 1) ? result : s.substring(start, end + 1);
                        break;
                    }
                }
                end--;
            }
            start++;
        }
        return result.length() == 0 ? new String(String.valueOf(chars[0])) : result;
    }

    // 回文判断
    public static boolean isPalindrome(String str, int start, int end) {
        char[] chars = str.toCharArray();
        while (start <= end) {
            if (chars[start] != chars[end - 1]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
