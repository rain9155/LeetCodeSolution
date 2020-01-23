package medium.leetcode375;

import java.util.Arrays;

/**
 * 猜数字大小 II:
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。
 * 直到你猜到我选的数字，你才算赢得了这个游戏。
 *
 * 示例:
 * n = 10, 我选择了8.
 * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
 * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
 * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
 * 游戏结束。8 就是我选的数字。
 * 你最终要支付 5 + 7 + 9 = 21 块钱。
 *
 * 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
        */
public class Solution {

    /**
     * 参考：
     * https://www.iteye.com/blog/univasity-1170216
     * https://www.cnblogs.com/fayin/p/10407176.html
     * https://www.cnblogs.com/grandyang/p/5677550.html
     * 递归 + 备忘录(极小极大算法)：
     * 玩猜数字时以最小的损失赢得游戏，在所有最坏的情况(每次都猜不中，最后才猜中)下取最好的情况
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int [] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return amount(dp, 1, n);
    }

    private int amount(int[][] dp, int start, int end){
        if(start >= end){//只有一个数，不用猜了，一定可以猜中，不用损失钱
            return 0;
        }
        if(dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
        //要猜中的数一定在这个范围中，随机挑一个数i开始猜，最终取最花费最少的i就行
        int minCount = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            //当前数不是结果，没有猜中，所以往左边或右边范围猜，要取左边或右边的花费最大值（极大，保证这局能赢）
            //例如右边的count > 左边的count最大，就取右边的count，因为这样保证从i开始，当i猜不中时，不管往左边还是右边猜，有足够的本钱，一定能赢
            int count = i + Math.max(amount(dp, start, i - 1), amount(dp, i + 1, end));
            //最终取最花费最少的i就行（极小，保证我们的损失最小）
            minCount = Math.min(minCount, count);
        }
        return dp[start][end] = minCount;
    }

    /**
     * 二维dp：
     * dp[i][j]表示在[i, j]这个范围内花费最少的钱(猜中数字)
     * 当只有一个数字时，一定可以猜中，这时花费为0
     * 当有两个数字时，选择最小的那个数字花费最少
     * 当有三个数字时，选择中间的那个数字花费最少
     * ...
     * 当有n个数字时, 选择[i, j]范围内所有最坏的情况下花费最少的情况
     * 所有，状态转移方程为：
     *              0                                                               (i == j)
     * dp[i][j] =
     *             min(dp[i][j], num + Math.max(dp[i][num - 1], dp[num + 1][j]))    (j > i)
     */
    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n + 2][n + 2];
        //dp对角线：当只有一个数字时，一定可以猜中，这时花费为0
        for(int i = 1; i <= n; i++){
            dp[i][i] = 0;
        }
        //从下往上，从左往右遍历dp数组
        for(int i = n; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                //尝试选择每一个数字num，然后以这个数字为中心，分为两个区间，取这两个区间加上猜测这个数字后的花费的最大值
                //当选择完所有数字后num，取所有num中花费的最小值(在所有最坏的情况下取最好的情况)
                for(int num = i; num <= j; num++){
                    dp[i][j] = Math.min(
                            dp[i][j],
                            num + Math.max(dp[i][num - 1], dp[num + 1][j])
                    );
                }
            }
        }
        return dp[1][n];
    }

}
