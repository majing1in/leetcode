package menu_code_1;

public class Code5_26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int target = 0;
        if (nums.length == 0) {
            return target;
        }
        int cur = nums[0] - 1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur != nums[i]) {
                nums[index] = nums[i];
                index++;
                target++;
                cur = nums[i];
            }
        }
        return target;
    }
}
