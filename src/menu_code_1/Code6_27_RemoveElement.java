package menu_code_1;

public class Code6_27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int target = 0;
        if (nums.length == 0) {
            return target;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index] = nums[i];
            target++;
            index++;
        }
        return target;
    }
}
