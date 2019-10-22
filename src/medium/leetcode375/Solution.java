package medium.leetcode375;

import java.util.Arrays;

/**
 * 猜数字大小 II:
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
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
     * 极小极大算法：
     * 玩猜数字时以最小的损失赢得游戏
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
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

}
