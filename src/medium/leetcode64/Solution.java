package medium.leetcode64;

/**
 * 最小路径和:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution {

    /**
     * O(mn)
     * 动态规划：
     * 把右下角看作起点，左上角看作终点。
     * 我们新建一个额外的 dp 数组，与原矩阵大小相同。
     * 在这个矩阵中，dp(i, j)表示从坐标 (i, j) 到右下角的最小路径权值。
     * 我们初始化右下角的 dp[m][n] 值为对应的原矩阵值，然后去填整个矩阵，对于每个元素考虑移动到右边或者下面，因此获得最小路径和我们有如下递推公式：
     * dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
     * 要注意边界情况，所以要先填充边界情况（最后一行、最后一列）
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int r = m - 1;
        int c = n - 1;
        //以右下角为起点
        dp[r][c] = grid[r][c];
        //累加填充最后一列
        for(int i = r - 1; i >= 0; i--){
            dp[i][c] = dp[i + 1][c] + grid[i][c];
        }
        //累加填充最后一行
        for(int j = c - 1; j >= 0; j--){
            dp[r][j] = dp[r][j + 1] + grid[r][j];
        }
        //从m - 1，n - 1开始根据右边和下面的最小元素得出当前的最优解
        for(int i = r - 1; i >= 0; i--){
            for(int j = c - 1; j >= 0; j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        //以左上角为终点
        return dp[0][0];
    }

}
