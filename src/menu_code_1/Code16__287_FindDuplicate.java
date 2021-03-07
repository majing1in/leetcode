package menu_code_1;

import java.util.Arrays;

public class Code16__287_FindDuplicate {

    public int findDuplicate(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return result;
    }
}
