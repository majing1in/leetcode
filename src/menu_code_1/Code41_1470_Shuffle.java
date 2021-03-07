package menu_code_1;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:36
 * @Email 1468835254@qq.com
 */
public class Code41_1470_Shuffle {

    /**
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ints = new int[nums.length];
        if (nums.length == 0 || n <= 0) {
            return new int[0];
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            ints[cur] = nums[i];
            ints[cur + 1] = nums[n + i];
            cur = cur + 2;
        }
        return ints;
    }
}
