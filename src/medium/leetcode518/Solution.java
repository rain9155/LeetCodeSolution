package medium.leetcode518;

import java.util.*;

/**
 * 零钱兑换 II:
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 */
public class Solution {

    int count = 0;
    Set<List<Integer>> pathCache = new HashSet<>();

    /**
     * 暴力：超时
     */
    public int change(int amount, int[] coins) {
        count(coins, amount, new ArrayList<>());
        return count;
    }

    private void count(int[] coins, int target, List<Integer> path) {
        if(target < 0){
            return;
        }
        if(target == 0){
            List<Integer> temp = new ArrayList<>(path);
            Collections.sort(temp);
            if(!pathCache.contains(temp)){
                count++;
                pathCache.add(temp);
            }
            return;
        }
        for(int i = 0; i < coins.length; i++){
            path.add(i);
            count(coins, target - coins[i], path);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 动态规划(二维dp)：
     * dp[i][j] 表示用i个硬币，可以组成j面额的硬币组合数
     * 所以状态转移方程为：（选与不选当前面额硬币）
     * dp[i][j] = dp[i - 1][j] + 【dp[i][j - coins[i]]（如果j >= coins[i]）】
     * 初始条件：
     * dp[i][0] = 1, 表示组成面额为0的硬币组合有多少种？只有一种，就是一个也不组合
     * 而dp[0][j] = 1(如果j % coins[0] == 0)
     */
    public int change2(int amount, int[] coins) {
        if(coins.length == 0 && amount == 0){
            return 1;
        }
        if(amount > 0 && coins.length == 0){
            return 0;
        }
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0){
                dp[0][j] = 1;
            }
        }
        for(int i = 0; i < len; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < len; i++){
            for(int j = 1; j <= amount; j++){
                dp[i][j] = dp[i - 1][j];
                if(coins[i] <= j){
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }

    /**
     * 动态规划(一维dp)
     */
    public int change3(int amount, int[] coins) {
        if(coins.length == 0 && amount == 0){
            return 1;
        }
        if(amount > 0 && coins.length == 0){
            return 0;
        }
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < len; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i] <= j){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

}
