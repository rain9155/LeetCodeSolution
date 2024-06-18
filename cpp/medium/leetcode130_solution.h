#pragma once
#include <vector>

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
namespace Leetcode130
{
    class Solution
    {
    public:
        /**
         * DFS:
         * 深度优先搜索，先找到边缘上所有为'O'的点，然后开始dfs，从边缘开始找到的'O'都是与边界联通的，所以先把它用“#”代替
         * 待边缘搜索完后，重新编辑board，遇到‘#’把它修改为‘O’，遇到‘O’把它修改为‘X’
         */
        void solve(std::vector<std::vector<char>>& board)
        {
            if(board.size() == 0) 
            {
                return;
            }
            int row = board.size();
            int col = board[0].size();
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(i == 0 || j == 0 || i == row - 1 || j == col - 1)
                    {
                        if(board[i][j] == 'O')
                        {
                            dfs(board, i, j, row, col);
                        }
                    }
                }
            }
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(board[i][j] == '#')
                    {
                        board[i][j] = 'O';
                    }
                    else if(board[i][j] == 'O')
                    {
                        board[i][j] = 'X';
                    } 
                }
            }
        }

        void dfs(std::vector<std::vector<char>>& board, int i, int j, int row, int col)
        {
            if(i < 0 || i >= row || j < 0 || j >= col)
            {
                return;
            }
            if(board[i][j] == 'X' || board[i][j] == '#')
            {
                return;
            }
            board[i][j] = '#';
            dfs(board, i + 1, j, row, col);
            dfs(board, i - 1, j, row, col);
            dfs(board, i, j + 1, row, col);
            dfs(board, i, j - 1, row, col);
        }
    };
}