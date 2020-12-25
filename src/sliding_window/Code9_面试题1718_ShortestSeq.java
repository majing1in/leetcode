package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Code9_面试题1718_ShortestSeq {

    public static void main(String[] args) {
        int[] seq = shortestSeq(new int[]{1, 1, 5, 9}, new int[]{1, 5, 9});
        Arrays.stream(seq).forEach(System.out::println);
    }

    public static int[] shortestSeq(int[] big, int[] small) {
        int[] target = new int[2];
        if (big.length == 0 || small.length == 0) {
            return target;
        }
        int len = small.length;
        boolean flag = false;
        boolean ok = false;
        int index = 0;
        int start = 0;
        int start_index = big.length;
        int end = 0;
        int end_index = big.length;
        int sum = big.length;
        HashMap<Integer, Integer> map = getArr(small);
        for (int i = index; i < big.length; i++) {
            if (len > 0) {
                if (map.containsKey(big[i])) {
                    if (!flag) {
                        start = i;
                        flag = true;
                    }
                    len--;
                    end = i;
                    if (len == 0) {
                        if (end - start == sum) {
                            if (start <= start_index) {
                                start_index = start;
                                end_index = end;
                            }
                        } else if (end - start < sum) {
                            sum = end - start;
                            start_index = start;
                            end_index = end;
                        }
                        i = start + 1;
                        ok = true;
                    }
                    map.remove(big[i]);
                }
            } else {
                i = start;
                len = small.length;
                flag = false;
                map = getArr(small);
            }
        }
        if (ok) {
            target[0] = start_index;
            target[1] = end_index;
            return target;
        }
        return new int[0];
    }

    public static HashMap<Integer, Integer> getArr(int[] small) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], 1);
        }
        return map;
    }
}
