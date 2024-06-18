package easy.leetcode121;

/**
 * 买卖股票的最佳时机:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution {


    /**
     * 动态规划：
     * dp[i]表示到第i天为止，手上持有的最大利润
     * 状态转移方程：dp[i] = max（dp[i - 1], prices[i] - min）, 其中min为prices中价格最低的股票
     * 初始条件：dp[0] = 0, 表示如果prices只有一支股票，利润为零，因为买入就不能卖出，亏本
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }


    /**
     * 波谷波峰：
     * 对于一次买卖股票要想得到最大利润就要低价买入高价卖出，所以我们把prices中各个元素的值想象成坐标点，然后把坐标点连成一条线，最大利润就是波谷和波峰的差值且波峰一定要在波谷的后面
     * 所以我们可以用valley表示波谷，grest表示波峰，即最大利润，然后遍历prices数组，每次先更新更新波谷为最低值，否则再更新更新波峰，即最大利润
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int valley = Integer.MAX_VALUE;//波谷
        int grest = 0;//波峰，即最大利润
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < valley){
                valley = prices[i];//更新波谷为最低值
            }else if(prices[i] - valley > grest){
                grest = prices[i] - valley;//更新波峰，即最大利润
            }
        }
        return grest;
    }

}
