package medium.leetcode289;

/**
 * 生命游戏:
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例:
 * 输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * 进阶:
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class Solution {

    /**
     * 原地修改：
     * 使用占位的方式，遍历这个board，
     * 当遇到死细胞时，如果死细胞需要复活，把该处赋值为3（0 -> 1），否则不变
     * 当遇到活细胞时，如果死细胞需要复活，把该处赋值为2（1 -> 0），否则不变
     * 最后再次遍历这个board，
     * 遇到3就把它变为1，遇到2就把它变为0，这样就可以原地修改
     */
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 0){
                   int count = count(board, i, j, row, col);
                   if(count == 3){
                       board[i][j] = 3;
                   }
                }else {
                    int count = count(board, i, j, row, col);
                   if(count < 2 || count > 3){
                       board[i][j] = 2;
                   }
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                    continue;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int count(int[][] board, int i, int j, int row, int col){
        int count = 0;
        //左上角
        if(i > 0){
            if(board[i - 1][j] == 1 || board[i - 1][j] == 2) count++;
        }
        if(i > 0 && j > 0){
            if(board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) count++;
        }
        if(i > 0 && j < col - 1){
            if(board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2) count++;
        }
        if(j > 0){
            if(board[i][j - 1] == 1 || board[i][j - 1] == 2) count++;
        }
        //右下角
        if(i < row - 1 && j > 0){
            if(board[i + 1][j - 1] == 1) count++;
        }
        if(i < row - 1){
            if(board[i + 1][j] == 1) count++;
        }
        if(i < row - 1 && j < col - 1){
            if(board[i + 1][j + 1] == 1) count++;
        }
        if(j < col - 1){
            if(board[i][j + 1] == 1) count++;
        }
        return count;
    }


}
