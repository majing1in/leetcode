package hot;

import java.util.Stack;

public class Code4_20_IsValid {

    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.empty()) {
                stack.add(aChar);
            } else {
                Character peek = stack.pop();
                if (peek == ']' || peek == '}' || peek == ')') {
                    return false;
                }
                if (peek == aChar - 1 || peek == aChar - 2) {

                } else {
                    stack.add(peek);
                    stack.add(aChar);
                }
            }
        }
        return stack.empty();
    }
}
