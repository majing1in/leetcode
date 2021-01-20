package hot;

import java.util.ArrayList;

public class Code1_152_MaxProduct {

    public static void main(String[] args) {
        int i = maxProduct2(new int[]{-3, 0, 1, -2});
        System.out.println(i);
    }

    public static int maxProduct2(int[] nums) {
        int target = 0;
        if (nums.length == 0) {
            return target;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int cur = start + 1;
        target = nums[start];
        while (start < nums.length - 1) {
            int temp = nums[start] * nums[cur];
            int tql = Math.max(nums[start], temp);
            while (++cur < nums.length) {
                temp = temp * nums[cur];
                tql = Math.max(tql, temp);
            }
            target = Math.max(target, tql);
            start++;
            cur = start + 1;
        }
        return Math.max(target, nums[nums.length - 1]);
    }
}
