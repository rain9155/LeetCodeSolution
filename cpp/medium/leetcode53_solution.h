#pragma once
#include <vector>

/**
 * 最大子数组:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例 1:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * 
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
namespace Leetcode53
{
    class Solution
    {
    public:
        /**
         * 动态规划：O(n)
         * dp[i]表示，到i为止的连续子序列的最大和
         * 每遍历到数组的一个元素时，取这个元素和这个元素加上前一个连续和的最大值为当前dp[i]的值
         * 状态转移公式：dp[i] = Math.max(nums[i], nums[i] + dp[i - 1])
         * 初始条件：dp[0] = nums[i], 当nums只有一个元素时，这个元素就是连续子序列的最大值
         */
        int maxSubArray(std::vector<int>& nums)
        {
            if(nums.size() == 0)
            {
                return 0;
            }
            std::vector<int> dp(nums.size());
            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1; i < nums.size(); i++)
            {
                dp[i] = std::max(nums[i], dp[i - 1] + nums[i]);
                max = std::max(max, dp[i]);
            }
            return max;
        }
    };
}