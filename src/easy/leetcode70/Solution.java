package easy.leetcode70;

/**
 * 爬楼梯:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution {

    /**
     * 动态规划：
     * 1 -》 1
     * 2 -》 2
     * 3 -》 1 + 2 = 3
     * 4 -》 2 + 3 = 5
     * n -> f(n - 2) + f(n - 1)
     * 每次只能跳一阶或两阶，所以第n阶的跳数就是第（n - 1）阶的跳数加上第（n - 2）阶的跳数，因为从（n - 1）阶跳一阶就到第n阶了，从第（n - 2）阶跳两阶就到第n阶了
     */
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }

    public int climbStairs2(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int temp = 1;
        int temp2 = 2;
        int ret = temp2;
        for(int i = 2; i < n; i++){
            ret = temp2 + temp;
            temp = temp2;
            temp2 = ret;
        }
        return ret;
    }

}
