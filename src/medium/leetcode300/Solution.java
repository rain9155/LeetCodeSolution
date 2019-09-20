package medium.leetcode300;

/**
 * 最长上升子序列：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {

    /**
     * O（n^2）
     * 动态规划：
     * 1、初始化dp[i] == 1，至少有一个长度的子序列，dp[i]表示在nums中从0到i的最大上升子序列的长度
     * 2、然后遍历nums，假设遍历到i
     *      这时dp[0]到dp[i - 1]已经知道
     * 3、然后我们再遍历nums[0...i - 1]，
     *      如果num[i] > nums[0...i - 1]之间的某一个数，则表示nums[i]可以拼接到nums[0...i - 1]的最后组成一个长度加1的上升子序列，
     *      这时我们就取dp[i] = max(dp[i], dp[j] + 1), dp[j]表示从0到i - 1的nums的最大上升子序列
     * 4、最后取max(dp[i])就是结果
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLen = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
           for(int j = 0; j < i ; j++){
              if(nums[i] > nums[j]){
                  dp[i] = Math.max(dp[i], dp[j] + 1);
              }
           }
           maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
