package simple;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:17
 * @Email 1468835254@qq.com
 */
public class Code6_1512_NumIdenticalPairs {

    /**
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        if (nums.length <= 1) {
            return result;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
