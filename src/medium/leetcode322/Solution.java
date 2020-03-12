package medium.leetcode322;

import java.util.Arrays;
import java.util.Collections;

/**
 * 零钱兑换:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution {

    /**
     * 动态规划：
     * 自顶向下，f(n)表示以n为总金额所组成的硬币个数最少
     * 假设n = 11， coins = [1, 2, 5],则：
     * f(11) = min(f(10), f(9), f(6))，而f(10) = min(f(9), f(8), f(4)), f(9) = ..., f(6) = ...，以此类推...
     * 注意要用一个cache数组缓存已经计算过的f(n), 例如上述的f(9)在递归计算f(10)时已经计算过了，则在计算f(9)时就不用重复计算
     */
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return 0;
        return coinChange(coins, 0, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int index, int amount, int[] cache) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(cache[amount] != 0) return cache[amount];
        int min = Integer.MAX_VALUE;
        for(int i = index; i < coins.length; i++){
            int res = coinChange(coins, index, amount - coins[i], cache);
            if(res != -1){
                min = Math.min(res + 1, min);
            }
        }
        int ret = min == Integer.MAX_VALUE ? -1 : min;
        cache[amount] = ret;
        return ret;
    }

    /**
     * 参考：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
     * 动态规划：
     * 自底向上，dp[i]表示以i为总金额所组成的最少硬币个数
     * 状态转移方程为：dp[i] = min(dp[i], dp[i - coins[j]] + 1), 0 <= j < coins.length, 1 <= i <= amount
     * base case: dp[0] = 0，表示目标金额为0所组成的最少硬币个数为0
     */
    public int coinChange2(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        //初始化dp[i]为一个不可能的值，因为能凑成amount金额的最大硬币数为amount，这时amount由所有面值为1的硬币组成
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            //如果无法添加任何一个coin后得到目标金额i，那么dp[i]保持不变，即保持为一个不可能的值
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 参考：https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
     * 贪心算法：
     */
    int min = Integer.MAX_VALUE;

    public int coinChange3(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0){
            return 0;
        }
        Arrays.sort(coins);
        count(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    private void count(int[] coins, int amount, int index, int count) {
        if(amount == 0){
            min = Math.min(min, count);
            return;
        }
        if(index < 0){
            return;
        }
        //算出当前amount里面有多少个这样面值的硬币
        int k = amount / coins[index];
        while(k >= 0 && k + count < min){
            //算出还剩下多少金额可以继续用其他硬币组合
            int remain = amount - k * coins[index];
            //用剩余的目标金额remain继续递归计算它的最大硬币组合数
            count(coins, remain, index - 1, k + count);
            //回溯，减少一个硬币数量
            k--;
        }
    }

}
