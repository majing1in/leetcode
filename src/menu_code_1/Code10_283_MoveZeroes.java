package menu_code_1;

public class Code10_283_MoveZeroes {

    /**
     * 心情不好，不想解释
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int start = nums[0];
        int width = start == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                width++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[i - width];
            nums[i - width] = temp;
        }
    }
}
