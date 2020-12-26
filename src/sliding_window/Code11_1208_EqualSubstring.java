package sliding_window;

public class Code11_1208_EqualSubstring {

    public static void main(String[] args) {
        int equalSubstring = equalSubstring("krrgw", "zjxss", 19);
        System.out.println(equalSubstring);
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int target = 0;
        if (s.length() == 0 || t.length() == 0) {
            return target;
        }
        if (maxCost < 1) {
            return target + 1;
        }
        char[] sc = s.toCharArray();
        char[] tg = t.toCharArray();

        return target;
    }
}
