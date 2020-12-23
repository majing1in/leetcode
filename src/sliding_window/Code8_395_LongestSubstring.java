package sliding_window;

public class Code8_395_LongestSubstring {

    public static void main(String[] args) {
        int longestSubstring = longestSubstring("aaabb", 3);
        System.out.println(longestSubstring);
    }

    public static int longestSubstring(String s, int k) {
        int target = 0;
        if (s.length() == 0) {
            return target;
        }
        char[] chars = s.toCharArray();
        int[] charLoc = new int[128];
        int[] charSum = new int[128];
        for (int i = 0; i < chars.length; i++) {
            if (charLoc[chars[i]] == 0) {
                charSum[chars[i]] = 1;
                charLoc[chars[i]] = 1;
            } else {
                charSum[chars[i]]++;
            }
        }
        for (int i = 0; i < charSum.length; i++) {
            if (charSum[i] >= k) {
                target = target + charSum[i];
            }
        }
        return target;
    }
}
