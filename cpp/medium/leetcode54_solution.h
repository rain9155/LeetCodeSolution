#pragma once
#include <vector>

/**
 * 螺旋矩阵:
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
namespace Leetcode54
{
    class Solution 
    {
    public:
        /**
         * 按层模拟：O(n)
         * 顺时针输出矩阵，就是按顺序把矩阵从外到内一层一层的输出元素
         * 每输出一层，起始点和边界都要做调整，起始点从（0，0）矩阵的左上角开始，边界从（m, n）开始
         * 要注意当最内层只有一行元素时，要跳过按行递减和按列递减的循环
         */
        std::vector<int> spiralOrder(std::vector<std::vector<int>>& matrix) 
        {
            std::vector<int> ret;
            if(matrix.size() == 0)
            {
                return ret;
            }
            int row = matrix.size();
            int col = matrix[0].size();
            int i = 0;
            int j = 0;
            while(i < row && j < col)
            {
                for(int c = j; c < col; c++)//固定行，移动列, 列递增
                {
                    ret.push_back(matrix[i][c]);
                }
                for(int r = i + 1; r < row; r++)
                {
                    ret.push_back(matrix[r][col - 1]);//固定列，移动行，行递增
                }
                //当次外层只剩下一条边时，跳过
                if(i < row - 1 && j < col - 1)
                {
                    for(int c = col - 2; c >= j; c--)//固定行，移动列, 列递减
                    {
                        ret.push_back(matrix[row - 1][c]);
                    }
                    for(int r = row - 2; r > i; r--)//固定列，移动行，行递减
                    {
                        ret.push_back(matrix[r][j]);
                    }
                }
                //调整起始点和边界
                i++;
                j++;
                row--;
                col--;
            }
            return ret;
        }
    };
}