package hot;

import java.util.Stack;

public class Code7_38_CountAndSay {

    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println(s);
    }


    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return dfs(2, n, "11");
    }

    public static String dfs(int start, int end, String target) {
        if (start < end) {
            StringBuilder sb = new StringBuilder();
            char[] chars = target.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (stack.size() == 0) {
                    stack.add(chars[i]);
                } else {
                    Character peek = stack.peek();
                    if (peek == chars[i]) {
                        stack.add(chars[i]);
                        continue;
                    }
                    sb.append(appendString(stack.size(), stack.peek()));
                    stack.removeAllElements();
                    i = i - 1;
                }
            }
            if (stack.size() > 0) {
                sb.append(appendString(stack.size(), stack.peek()));
            }
            return dfs(++start, end, sb.toString());
        } else {
            return target;
        }
    }

    public static StringBuilder appendString(int size, char c) {
        StringBuilder builder = new StringBuilder();
        builder.append(size);
        builder.append(c);
        return builder;
    }

}
