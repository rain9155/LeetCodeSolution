#pragma once
#include <vector>
#include "../common/struct.h"

using namespace Common;

/**
 * 买卖股票的最佳时机:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 */
namespace Leetcode121
{
    class Solution
    {
    public:
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