package menu_code_1;

import java.util.ArrayList;
import java.util.List;

public class Code25_78_Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }

    static List<List<Integer>> lists = new ArrayList<>();

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        lists.add(new ArrayList<>());
        if (nums.length == 0) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            lists.add(list);
            dfs(nums, i, list, new ArrayList<>());
        }
        // 去重
        for (int i = lists.size() - 1; i >= 0; i--) {
            for (int i1 = i - 1; i1 >= 0; i1--) {
                if (lists.get(i).size() == 0 || lists.get(i1).size() == 0) {
                    continue;
                }
                if (lists.get(i).size() == lists.get(i1).size() && lists.get(i).containsAll(lists.get(i1))) {
                    lists.remove(i);
                    break;
                }
            }
        }
        return lists;
    }

    /**
     * @param nums   元数据
     * @param cur    游标
     * @param dList  数据层 1
     * @param dLists 数据层 2
     */
    public static void dfs(int[] nums, int cur, List<Integer> dList, List<List<Integer>> dLists) {
        if (cur == nums.length - 1) {
            List<List<Integer>> list = new ArrayList<>(dLists);
            lists.addAll(list);
            return;
        }
        for (int i = cur + 1; i < nums.length; i++) {
            dList.add(nums[i]);
            List<Integer> list = new ArrayList<>(dList);
            dLists.add(list);
            dfs(nums, i, list, dLists);
            dList.remove(dList.size() - 1);
            dLists.remove(dLists.size() - 1);
        }
    }
}
