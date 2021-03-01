package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 23:27
 * @Email 1468835254@qq.com
 */
public class Code8_1431_KidsWithCandies {

    /**
     * 给你一个数组candies和一个整数extraCandies，其中candies[i]代表第 i 个孩子拥有的糖果数目。
     * 对每一个孩子，检查是否存在一种方案，将额外的extraCandies个糖果分配给孩子们之后，此孩子有 最多的糖果。注意，允许有多个孩子同时拥有 最多的糖果数目。
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            int val = candies[i] + extraCandies;
            boolean flag = false;
            for (int j = 0; j < candies.length; j++) {
                if (i == j) {
                    continue;
                }
                if (val > candies[j]) {
                    flag = true;
                    break;
                }
            }
            booleans.add(!flag);
        }
        return booleans;
    }
}
