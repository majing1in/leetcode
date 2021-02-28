package double_clip;

public class Code1_125_IsPalindrome {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        String lowerCase = s.toLowerCase();
        char[] chars = lowerCase.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!((chars[left] >= 48 && chars[left] <= 57)
                    || (chars[left] >= 65 && chars[left] <= 90)
                    || (chars[left] >= 97 && chars[left] <= 122))) {
                left++;
                continue;
            }
            if (!((chars[right] >= 48 && chars[right] <= 57)
                    || (chars[right] >= 65 && chars[right] <= 90)
                    || (chars[right] >= 97 && chars[right] <= 122))) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
