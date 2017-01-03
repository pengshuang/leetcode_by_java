/**
 * Created by pengshuang on 17/1/3.
 * 如果允许多次购买卖出的情况
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int buy = prices[0];
        int sell = prices[0];
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= sell) {
                sell = prices[i];
            } else {
                profits += (sell - buy);
                buy = sell = prices[i];
            }
        }
        profits += (sell - buy);
        return profits;
    }
}
