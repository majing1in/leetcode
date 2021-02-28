package hot;

public class Code9_121_MaxProfit {

    /**
     * 不想解释 懂的都懂
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        if (prices.length <= 1) {
            return maxPrice;
        }
        int a = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > a) {
                if (maxPrice < prices[i] - a) {
                    maxPrice = prices[i] - a;
                }
                continue;
            }
            a = prices[i];
        }
        return maxPrice;
    }
}
