package hot;

import java.util.Arrays;

public class Code2_821_ShortestToChar {

    public static void main(String[] args) {
        int[] ints = shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));
    }

    public static int[] shortestToChar(String S, char C) {
        int[] target = new int[S.length()];
        int first = S.indexOf(C);
        int second = S.indexOf(C, first + 1) != -1 ? S.indexOf(C, first + 1) : first;
        for (int i = 0; i < S.length(); i++) {
            int abs1 = Math.abs(i - first);
            int abs2 = Math.abs(i - second);
            target[i] = Math.min(abs1, abs2);
            if (i == second) {
                first = second;
                second = S.indexOf(C, first + 1) != -1 ? S.indexOf(C, first + 1) : first;
            }
        }
        return target;
    }
}
