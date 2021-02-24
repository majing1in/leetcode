package hot;

public class Code22_647_CountSubstrings {

    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int result = 0;
        if (s.length() == result) {
            return result;
        }
        char[] chars = s.toCharArray();
        // 每个字符都是回文
        result = chars.length;
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                // 字符不同直接跳过
                if (chars[i] != chars[j]) {
                    continue;
                }
                int k = i, z = j;
                boolean b = false;
                // 回文判断
                while (k <= z) {
                    if (chars[k] != chars[z]) {
                        b = true;
                        break;
                    }
                    k++;
                    z--;
                }
                if (!b) {
                    result++;
                }
            }
        }
        return result;
    }
}
