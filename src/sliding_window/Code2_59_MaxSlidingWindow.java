package sliding_window;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Author: 马同学
 * @Date: 2020/12/20 0020 22:21
 */
public class Code2_59_MaxSlidingWindow {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ints = new int[nums.length - k + 1];
        int index = 0;
        while (index < nums.length - k + 1) {
            int value = nums[index];
            for (int i = index + 1; i < k + index; i++) {
                if (nums[i] > value) {
                    value = nums[i];
                }
            }
            ints[index] = value;
            index++;
        }
        return ints;
    }
}
