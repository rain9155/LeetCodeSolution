#pragma once
#include <vector>
#include "../common/struct.h"

using namespace Common;

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
namespace Leetcode121
{
    class Solution
    {
    public:
        /**
         * 动态规划：
         * dp[i]表示到第i天为止，手上持有的最大利润
         * 状态转移方程：dp[i] = max（dp[i - 1], prices[i] - min）, 其中min为prices中价格最低的股票
         * 初始条件：dp[0] = 0, 表示如果prices只有一支股票，利润为零，因为买入就不能卖出，亏本
         */
        int maxProfit(std::vector<int>& prices)
        {
            if(prices.empty())
            {
                return 0;
            }
            int min = prices[0];
            std::vector<int> dp(prices.size());
            dp.push_back(0);
            for(int i = 1; i < prices.size(); i++)
            {
                int money = prices[i] - min;
                dp[i] = money > dp[i - 1] ? money : dp[i - 1];
                min = prices[i] < min ? prices[i] : min;
            }
            return dp[dp.size() -1];
        }
    };
}