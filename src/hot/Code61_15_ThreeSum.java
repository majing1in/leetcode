package hot;

import java.util.ArrayList;
import java.util.List;

public class Code61_15_ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0});
        System.out.println(lists);
    }

    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return lists;
        }
        boolean[] booleans = new boolean[nums.length];
        dfs(nums, booleans, new ArrayList<>(), 0);
        // TODO 去重
        return lists;
    }

    public static void dfs(int[] nums, boolean[] booleans, List<Integer> list, int cur) {
        if (list.size() == 3) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum = sum + list.get(i);
            }
            if (sum == 0) {
                ArrayList<Integer> arrayList = new ArrayList<>(list);
                lists.add(arrayList);
            }
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            if (!booleans[i]) {
                booleans[i] = true;
                list.add(nums[i]);
                dfs(nums, booleans, list, ++cur);
                booleans[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
