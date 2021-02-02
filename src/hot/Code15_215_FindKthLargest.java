package hot;

import java.util.Arrays;

public class Code15_215_FindKthLargest {

    public static void main(String[] args) {
        int largest = findKthLargest(new int[]{1,1,1}, 2);
        System.out.println(largest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == 1) {
                result = nums[i];
                break;
            }
            k--;
        }
        return result;
    }
}
