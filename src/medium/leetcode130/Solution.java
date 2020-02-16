package medium.leetcode130;

import common.structure.UF;

/**
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution {


    /**
     * DFS:
     * 深度优先搜索，先找到边缘上所有为'O'的点，然后开始dfs，从边缘开始找到的'O'都是与边界联通的，所以先把它用“#”代替
     * 待边缘搜索完后，重新编辑board，遇到‘#’把它修改为‘O’，遇到‘O’把它修改为‘X’
     */
    public void solve(char[][] board) {
        if(board  == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                //找到边界上为‘O’的位置，然后从这个位置开始做dfs，遇到‘O’就修改为‘#’
                if(i == 0 || j == 0 || i == row - 1 || j == col - 1){
                    if(board[i][j] == 'O'){
                        solve(board, i, j);                    }
                }
            }
        }
        //重新编辑board，被修改为‘#’的‘O’说明是与边界相连的，把它修改为‘O’，而原来没有被修改为‘#’的的‘O’说明没有与边界相连，把它修改为‘X’
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void solve(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X') return ;
        board[i][j] = '#';
        solve(board, i, j - 1);
        solve(board, i, j + 1);
        solve(board, i - 1, j);
        solve(board, i + 1, j);
    }

    /**
     * 并查集：
     * 新建一个dummy节点，把所有和边界相连的O于dummy合并成一个连通分量
     * 然后再遍历一遍board，把不属于dummy连通分量的O置为X
     */
    public void solve2(char[][] board) {
        if(board  == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        //新建并查集，初始化连通分量为二维数组元素数量 + 1
        UF uf = new UF(row * col + 1);
        //并查集的最后一个节点为虚拟节点
        int dummy = row * col;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0 || i == row - 1 || j == col - 1){
                    //把边界位置的O和dummy合并
                    if(board[i][j] == 'O'){
                        uf.union(col * i + j, dummy);
                    }
                }
            }
        }
        int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                //遍历元素是O的上下左右位置
                if(board[i][j] == 'O'){
                    for(int k = 0; k < d.length; k++){
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        //如果该位置是O，就把board[x][y]和board[i][j]合并起来
                        if(board[x][y] == 'O'){
                            uf.union(col * x + y, col * i + j);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                //把不和边界连通的O置为X
                if(board[i][j] == 'O' && !uf.isConnected(col * i + j, dummy)){
                    board[i][j] = 'X';
                }
            }
        }
    }

}
