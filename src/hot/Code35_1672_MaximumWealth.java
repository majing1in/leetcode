package hot;

/**
 * @Author Xiaoma
 * @Date 2021/2/28 0028 22:53
 * @Email 1468835254@qq.com
 */
public class Code35_1672_MaximumWealth {

    /**
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        if (accounts.length == 0) {
            return result;
        }
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum = sum + accounts[i][j];
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
