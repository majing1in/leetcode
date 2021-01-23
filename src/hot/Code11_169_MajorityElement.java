package hot;

import java.util.Arrays;

public class Code11_169_MajorityElement {

    /**
     *  弱智暴力解法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        if (nums.length == 0){
            return result;
        }
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int count2 = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count2++;
                }
            }
            result = count1 > count2 ? result : nums[i];
            count1 = Math.max(count1, count2);
        }
        return result;
    }
}
