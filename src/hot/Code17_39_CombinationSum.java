package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code17_39_CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0) {
            return results;
        }
        int left = 0;
        while (left < candidates.length) {
            int cur = left;
            int temp = target - candidates[left];
            List<Integer> list = new ArrayList<>();
            if (temp == 0) {
                list.add(candidates[left]);
                results.add(list);
                return results;
            }
            if (temp < 0) {
                break;
            }
            list.add(candidates[left]);
            while (temp > 0) {
                list.add(candidates[cur]);
                temp = temp - candidates[cur];
                if (temp == 0) {
                    results.add(list);
                    break;
                }
                if (temp < candidates[cur]) {
                    Integer remove = list.remove(list.size() - 1);
                    temp = temp + remove - candidates[cur];
                    if (temp == 0) {
                        list.add(candidates[cur]);
                        results.add(list);
                    } else {
                        cur++;
                    }
                }
            }
            left++;
        }
        return results;
    }

}
