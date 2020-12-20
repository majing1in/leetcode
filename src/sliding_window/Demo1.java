package sliding_window;

/**
 * 53. 最大子序和
 * @Author: 马同学
 * @Date: 2020/12/20 0020 18:44
 */
public class Demo1 {

    /**
     * -2,1,-3,4,-1,2,1,-5,4
     *
     * @param args
     */
    public static void main(String[] args) {
        int maxSubArray = maxSubArray(new int[]{-2, 1});
        System.out.println(maxSubArray);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int target = nums[0];
        int index = 0;
        while (index < nums.length) {
            int temp = index;
            int sum = nums[temp];
            if (target < nums[temp]) {
                target = nums[temp];
            }
            while (temp < nums.length - 1) {
                sum = sum + nums[temp + 1];
                if (sum > target) {
                    target = sum;
                }
                temp++;
            }
            index++;
        }
        return target;
    }
}
