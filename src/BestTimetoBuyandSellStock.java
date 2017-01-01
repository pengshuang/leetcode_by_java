/**
 * Created by pengshuang on 17/1/1.
 * 贪心法,分别找到价格最低和收益最多的值
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int buy = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            max = Math.max(max, prices[i]-buy);
            buy = Math.min(buy, prices[i]);
        }
        return max;
    }
}
