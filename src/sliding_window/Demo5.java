package sliding_window;

/**
 * 424. 替换后的最长重复字符
 */
public class Demo5 {

    public static void main(String[] args) {
        int replacement = characterReplacement("AABBB", 1);
        System.out.println(replacement);
    }

    public static int characterReplacement(String s, int k) {
        int target = 0;
        char[] chars = s.toCharArray();
        int loc = 0;
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
                if (sum > target) {
                    target = sum;
                    loc = index;
                }
            }
            if (count > 0) {
                if (loc + count <= s.length()) {
                    if (index > count) {
                        sum = sum + count;
                    } else {
                        sum = sum + index;
                    }
                }
            }
            if (sum > target) {
                target = sum;
                loc = index;
            }
        }
        return target;
    }
}
