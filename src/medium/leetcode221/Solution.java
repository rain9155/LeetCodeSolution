package medium.leetcode221;

/**
 * 最大正方形:
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class Solution {

    /**
     * O(n^2)
     * 动态规划：
     * 初始化二维数组dp[][], 其中dp[i][j]表示到（i， j）点所组成的正方形的最大边长，并用maxLen记录遍历过程中出现的最大正方形边长
     * 1、边界条件：当i == 0 或 j == 0时，dp[i][j] = matrix[i][j] - '0'
     * 2、当matrix[i][j] == '1'时有状态转移公式：dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
     *    当当matrix[i][j] == '0'时，dp[i][j] == 0
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxLen = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }else {
                    if(matrix[i][j] == '1')
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }

}
