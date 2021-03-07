package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 22:46
 * @Email 1468835254@qq.com
 */
public class Code34_1480_RunningSum {

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] ints = new int[nums.length];
        if (nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum = nums[j] + sum;
            }
            ints[i] = sum;
        }
        return ints;
    }
}
