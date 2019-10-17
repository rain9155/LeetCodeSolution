package medium.leetcode357;

/**
 * 计算各个位数不同的数字个数:
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class Solution {

    /**
     * 动态规划 + 排列组合：
     * 例如n = 2，向放第一位，有9个数（1-9）放，再放第二位，有10个数（0-9）放，但是不能和第一位重复，所以第二位只能放9个数，所以当n = 2时， 各位数字都不同的数字 x = 9 * 9 种可能
     * n = 0, x = 1
     * n = 1, x = 9 + 1 = 10
     * n = 2, x = 9 * 9 + 10 = 91
     * n = 3, x = 9 * 9 * 8 + 91 = 739
     * ...
     * n = i, dp[i] = dp[i - 1] + dp[i - 1] - dp[i - 2] * (10 - i - 1)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n < 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int factor = 10;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i - 1] + 9;
            }else{
                factor -= 1;
                dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * factor;
            }
        }
        return dp[n];
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if(n < 0) return 0;
        int prePreCur = 1;
        int preCur = -1;
        int cur = prePreCur;
        int factor = 10;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                cur = prePreCur + 9;
                preCur = cur;
            }else{
                factor -= 1;
                //dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * factor;
                cur = preCur + (preCur - prePreCur) * factor;
                prePreCur = preCur;
                preCur = cur;
            }
        }
        return cur;
    }

}
