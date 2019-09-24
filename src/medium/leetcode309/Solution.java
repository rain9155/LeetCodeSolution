package medium.leetcode309;

/**
 * 最佳买卖股票时机含冷冻期:
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Solution {

    /**
     * 动态规划：
     * 参考思路：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
     *
     * 定义3个状态：买入buy、卖出sell、冷冻期cool，每一天都是这3个状态之一：
     *
     * 1、sell[i]表示到第i天卖出股票的最大利润：sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i])；
     *      sell[i]的前一天状态只能是sell或buy，不可能是cool，因为买入卖出后才会进入cool，所以sell不可能由cool转换来；
     *      如果是bug，今天卖出股票能获得最大利润，就在前一天bug的利润的基础上加上prices成为今天的最大利润；
     *      如果是sell，今天继续保持昨天卖出的收益；
     *      所以最终取sell和buy + prices的最大值
     *
     * 2、bug[i]表示第i天买入股票的最大利润：buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
     *      buy[i]的前一天状态只能是buy或cool，不可能是sell，因为买入卖出就会进入cool，cool一定会在buy之前，所以buy不可能由sell转换来；
     *      如果是cool，今天要可以买入股票，不是冷冻期，就在前一天cool的利润的基础上减去买股票的钱prices成为今天的最大利润；
     *      如果是bug，今天继续保持昨天买入的收益；
     *      所以最终取buy和cool - prices的最大值
     *
     * 3、cool[i]表示第i天是冷冻期的最大利润： Math.max(cool[i - 1], sell[i - 1])
     *      cool的前一天只能是sell或cool，不可能是买入buy，因为只有前一天是sell，今天才会进入cool状态，所以cool不可能由buy转换来；
     *      如果是sell，今天是冷冻期，不可以卖出股票，所以就取前一天sell的利润今天的最大利润；
     *      如果是cool，今天继续保持昨天冷冻期的收益；
     *      所以最终取sell和cool的最大值
     *
     * 4、最终手上没有股票持有，代表所有股票卖出，这时才能获得最大收益，返回sell[len - 1]。
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] cool = new int[prices.length];
        buy[0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
        }
        return sell[prices.length - 1];
    }

}
