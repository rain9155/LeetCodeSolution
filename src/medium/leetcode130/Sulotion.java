package medium.leetcode130;

/**
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
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
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Sulotion {

    public void solve(char[][] board) {
        if(board  == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                char c = board[i][j];
                if(c == 'O' && board[i - 1][j] == 'X' && board[i][j - 1] == 'X' && board[i + 1][j] == 'X' && board[i][j + 1] == 'X' ){
                    board[i][j] = 'X';
                }
            }
        }
    }

}
