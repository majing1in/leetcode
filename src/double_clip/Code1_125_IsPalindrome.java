package double_clip;

public class Code1_125_IsPalindrome {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(".,");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (!((chars[left] >= 65 && chars[left] <= 90) || (chars[left] >= 97 && chars[left] <= 122))) {
                left++;
                if (left == chars.length) {
                    return true;
                }
            }
            while (!((chars[right] >= 65 && chars[right] <= 90) || (chars[right] >= 97 && chars[right] <= 122))) {
                right--;
                if (right < 0) {
                    return true;
                }
            }
            int abs = Math.abs(chars[left] - chars[right]);
            if (abs == 0 || abs == 32) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
