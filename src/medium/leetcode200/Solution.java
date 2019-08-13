package medium.leetcode200;

import java.math.BigInteger;

/**
 * 岛屿数量:
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class Solution {

    /**
     * dfs：
     * 遇到 '1' ，就以这个'1'开始dfs，在dfs中把所有相连的 '1' 都设置成 '*'
     * 一个dfs完成后，岛屿数count加一
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, row, col, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col, int i, int j){
        if(i < 0 || i >= row || j < 0 || j >= col) return;
        if(grid[i][j] == '0' || grid[i][j] == '*') return;
        grid[i][j] = '*';
        dfs(grid, row, col, i - 1, j);
        dfs(grid, row, col, i + 1, j);
        dfs(grid, row, col, i, j - 1);
        dfs(grid, row, col, i, j + 1);
    }

}
