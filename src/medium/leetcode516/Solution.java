package medium.leetcode516;

/**
 * 最长回文子序列:
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * 示例 2:
 * 输入:
 * "cbbd"
 * 输出:
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 */
public class Solution {

    /**
     * 参考leetcode第5题（最长回文子串）
     * 动态规划：
     * 状态
     * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     * 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * f[i][j] = f[i + 1][j - 1] + 2
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * f[i][j] = max(f[i + 1][j], f[i][j - 1])
     * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     * 初始化
     * f[i][i] = 1 单个字符的最长回文序列是 1
     * 结果
     * f[0][n - 1]
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        //dp[i][j]表示在s中[i, j]位置的最长回文子序列是多长
        int[][] dp = new int[len][len];
        //从后往前，从左往右遍历,保证每个子问题已经求解出
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                //base条件，只有1个元素，回文长度当然为1
                if(i == j){
                    dp[i][j] = 1;
                }else {
                    //状态转移方程：dp[i][j] =  dp[i + 1][j - 1] + 2 (s[i] == s[j])
                    //因为如果s[i] == s[j], 那么[i, j]可以在[i + 1, j - 1]的长度上加2组成更长的回文串
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else {
                        //那么dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);(s[i] != s[j])
                        //因为s[i] != s[j], 那么那么[i, j]一定不可以在[i + 1, j - 1]的基础上组成更长的回文串，保持原本的最大值即可
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

}
