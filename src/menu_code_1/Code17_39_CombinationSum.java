package menu_code_1;

import java.util.ArrayList;
import java.util.List;

public class Code17_39_CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (candidates.length == 0) {
            return results;
        }
        // TODO
        return results;
    }

    public static void dfs() {

    }

}
