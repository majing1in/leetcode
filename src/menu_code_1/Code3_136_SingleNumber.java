package menu_code_1;

public class Code3_136_SingleNumber {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        int target = 0;
        if (nums.length == 0) {
            return target;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean bln = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    bln = true;
                    break;
                }
            }
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] == nums[i]) {
                    bln = true;
                    break;
                }
            }
            if (!bln) {
                target = nums[i];
            }
        }
        return target;
    }
}
