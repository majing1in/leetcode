package menu_code_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code2_347_TopKFrequent {

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        /*
            双集合关系映射
            numbers  返回的元素
            values   返回元素对应的出现频率
         */
        List<Integer> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            int cur = i + 1;
            while (cur < nums.length && nums[i] == nums[cur]) {
                cur++;
                count++;
            }
            if (numbers.size() < k) {
                numbers.add(nums[i]);
                values.add(count);
            } else {
                // 即将被移除元素的下标
                int removeIndex = -1;
                // 元素对比值
                int removeValue = count;
                // 循环一次集合找到最小的元素的下表
                for (int j = 0; j < values.size(); j++) {
                    if (values.get(j) <= removeValue) {
                        removeIndex = j;
                        removeValue = values.get(j);
                    }
                }
                // 移除元素
                if (removeIndex != -1) {
                    values.remove(removeIndex);
                    numbers.remove(removeIndex);
                    values.add(count);
                    numbers.add(nums[i]);
                }
            }
            // 更新下一次的下标位置
            i = i + count - 1;
        }
        // 当返回元素不足时，证明最后一个元素需要被返回
        if (numbers.size() < k) {
            numbers.add(nums[nums.length - 1]);
        }
        int[] ints = new int[k];
        for (int i = 0; i < numbers.size(); i++) {
            ints[i] = numbers.get(i);
        }
        return ints;
    }
}
