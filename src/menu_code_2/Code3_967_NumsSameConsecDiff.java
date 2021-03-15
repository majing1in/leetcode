package menu_code_2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Code3_967_NumsSameConsecDiff {

    public static void main(String[] args) {
        int[] ints = numsSameConsecDiff(2, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
     * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0是有效的。
     * 你可以按 任何顺序 返回答案。
     *
     * @param n
     * @param k
     * @return
     */
    public static Set<Integer> set = new HashSet<>();

    public static int[] numsSameConsecDiff(int n, int k) {
        // 遍历 1 - 9
        for (int i = 1; i <= 9; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            // builder 存放目标数字，i 为数字开头
            dfs(n, k, i, builder);
        }
        int[] results = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int cur = 0;
        while (iterator.hasNext()) {
            results[cur] = iterator.next();
            cur++;
        }
        return results;
    }

    public static void dfs(int n, int k, int tar, StringBuilder val) {
        if (val.length() == n) {
            // 不能已 0 开头
            if (!val.toString().startsWith("0")) {
                // set 集合去重
                set.add(Integer.parseInt(val.toString()));
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(i - tar) == k) {
                val.append(i);
                dfs(n, k, i, val);
                val.delete(val.length() - 1, val.length());
            }
        }
    }

}
