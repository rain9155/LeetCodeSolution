package medium.leetcode63;

/**
 * 不同路径 II:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Solution {

    /**
     * O（n^2）
     * 动态规划：
     * 在i == 0 或 j == 0中，如果遇到障碍物，那么dp[0][j] 或 dp[i][0] 以及后面的方格都置为0，如果在没有遇到障碍物之前，都置为1
     * 在 i > 0 或 j > 0中，如果遇到障碍物，那么dp[i][j]就置为0，否则就使用状态转移公式计算当前路径数：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
              if(i == 0 && j == 0){
                  if(obstacleGrid[i][j] == 1){
                      return 0;
                  }else{
                      dp[i][j] = 1;
                      continue;
                  }
              }
              if(i == 0){
                  if(obstacleGrid[i][j] == 1){
                      dp[i][j] = 0;
                  }else {
                      dp[i][j] = dp[i][j - 1];
                  }
              }
              if(j == 0){
                  if(obstacleGrid[i][j] == 1){
                      dp[i][j] = 0;
                  }else {
                      dp[i][j] = dp[i - 1][j];
                  }
              }
              if(i > 0 && j > 0){
                  if(obstacleGrid[i][j] == 1){
                      dp[i][j] = 0;
                  }else {
                      dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                  }
              }
            }
        }
        return dp[m - 1][n - 1];
    }

}
