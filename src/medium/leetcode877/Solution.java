package medium.leetcode877;

import java.util.Arrays;

/**
 * 石子游戏：
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * 示例：
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *  
 * 提示：
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 */
public class Solution {

    /**
     * 递归 + 备忘录(蛮力法)：
     * 模拟亚历克斯和李轮流取石子的过程，用一个boolean变量round表示轮到哪个人，当round为true时，表示轮到亚历克斯取石头，false则表示轮到李取石头
     * 如果轮到亚历克斯，他要选择取最左边的或者最右边的石头，取完后把取走的石头数量累加到cur上，只要某一边能赢(返回true，即cur大于sum的一半)，就代表亚历克斯可以赢得这场比赛
     * 如果轮到李，他也要选择取最左边的或者最右边的石头，取完后不做任何累加操作，递归轮到亚历克斯
     */
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int pile : piles){
            sum += pile;
        }
        int[][] dp = new int[piles.length][piles.length];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return stoneGame(piles, 0, piles.length - 1, 0, sum, false, dp);
    }

    public boolean stoneGame(int[] piles, int start, int end, int curSum, int sum, boolean round, int[][] dp) {
        if(start > end){
            return curSum > sum / 2;
        }
        if(dp[start][end] != -1){
            return dp[start][end] != 0;
        }
        round = !round;
        if(round){
            boolean ret = stoneGame(piles, start + 1, end, curSum + piles[start], sum, round, dp)
                    || stoneGame(piles, start, end - 1, curSum + piles[end], sum, round, dp);
            dp[start][end] = ret ? 1 : 0;
            return ret;
        }else{
            boolean ret = stoneGame(piles, start + 1, end, curSum, sum, round, dp)
                    || stoneGame(piles, start, end - 1, curSum, sum, round, dp);
            dp[start][end] = ret ? 1 : 0;
            return ret;
        }
    }

    /**
     * 参考：https://leetcode-cn.com/problems/stone-game/solution/dong-tai-gui-hua-by-cliant/
     * 二维dp：
     * dp[i][j]表示在[i, j]这几堆石头中，先手比后手拿到手的多出的石头数
     * 当piles只有一堆石头时，只能让先手拿掉，这时dp[i][i]就等于piles[i]
     * 当piles大于两堆石头时，先手只能选择取最左边piles[i]或最右边的石头piles[l]：
     *      当他取走最左边的那堆石头piles[i]时，下一轮的先手多出的石头数为dp[i + 1][j]，所以本轮先手多出的石头数piles[i] - dp[i + 1][j]
     *      当他取走最右边的那堆石头piles[j]时，下一轮的先手多出的石头数为dp[i][j - 1]，所以本轮先手多出的石头数piles[j] - dp[i][j - 1]
     *      所以本轮先手只要取max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])就行
     * 综上所述，状态转移方程为：
     *              piles[i]                                                  (i == j)
     * dp[i][j] =
     *              max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])     (j > i)
     */
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //dp对角线：当piles只有一堆石头时，只能让先手拿掉
        for(int i = 0; i < n; i++){
            dp[i][i] = piles[i];
        }
        //从下往上，从左往右遍历dp，dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                dp[i][j] = Math.max(
                        piles[i] - dp[i + 1][j],
                        piles[j] - dp[i][j - 1]
                );
            }
        }
        return dp[0][n - 1] > 0;
    }

}
