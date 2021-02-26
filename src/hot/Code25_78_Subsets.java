package hot;

import java.util.ArrayList;
import java.util.List;

public class Code25_78_Subsets {

    //TODO
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        lists.add(new ArrayList<>());
        if (nums.length == 0) {
            return lists;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            boolean[] bln = new boolean[nums.length];
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            lists.add(list);
            dfs(nums, bln, list, new ArrayList<>(), i + 1);
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[nums.length - 1]);
        lists.add(list);
        return lists;
    }

    public static void dfs(int[] nums, boolean[] bln, List<Integer> src, List<List<Integer>> total, int index) {
        if (index == nums.length) {
            List<List<Integer>> temp = new ArrayList<>(total);
            lists.addAll(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!bln[i]) {
                src.add(nums[i]);
                total.add(new ArrayList<>(src));
                bln[i] = true;
                dfs(nums, bln, src, total, index);
                src.remove(src.size() - 1);
                total.remove(total.size() - 1);
                bln[i] = false;
            }
        }
     }
}
