package menu_code_1;

public class Code27_344_ReverseString {

    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char cLeft = s[left];
            char cRight = s[right];
            char c = cLeft;
            s[left] = cRight;
            s[right] = c;
            left++;
            right--;
        }
    }
}
