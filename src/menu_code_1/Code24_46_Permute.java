package menu_code_1;

import java.util.ArrayList;
import java.util.List;

public class Code24_46_Permute {

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        System.out.println(lists);
    }

    static List<List<Integer>> lists = new ArrayList<>();

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return lists;
        }
        boolean[] bln = new boolean[nums.length];
        dfs(nums, bln, new ArrayList<>());
        return lists;
    }

    /**
     * @param nums  原数组
     * @param bln   原数组对照变量
     * @param list  每次循环的结果集
     */
    public static void dfs(int[] nums, boolean[] bln, List<Integer> list) {
        if (list.size() == nums.length) {
            List<Integer> target = new ArrayList<>(list);
            lists.add(target);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!bln[i]) {
                list.add(nums[i]);
                bln[i] = true;
                dfs(nums, bln, list);
                // 恢复变量值
                list.remove(list.size() - 1);
                bln[i] = false;
            }
        }
    }

}
