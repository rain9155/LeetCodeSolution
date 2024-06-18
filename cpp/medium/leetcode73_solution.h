#pragma once
#include <vector>

/**
 * 矩阵置零:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
namespace Leetcode73
{
    class Solution 
    {
    public:
        /**
         * 原地算法：O(nm(n + m))
         * 1、遍历原始矩阵，如果发现如果某个元素 matrix[i][j] 为 0， 我们将第 i 行和第 j 列的所有非零元素设成很大的负虚拟值
         * 2、最后，我们遍历整个矩阵将所有等于虚拟值的元素设为 0。
         */
        void setZeroes(std::vector<std::vector<int>>& matrix) 
        {
            if(matrix.size() == 0)
            {
                return;
            }
            int r = matrix.size();
            int c = matrix[0].size();
            const int dumy_value = -100000;
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    if(matrix[i][j] == 0)
                    {
                        for(int t = 0; t < c; t++)
                        {
                            if(matrix[i][t] != 0)
                            {
                                matrix[i][t] = dumy_value;
                            }
                        }
                        for(int t = 0; t < r; t++)
                        {
                            if(matrix[t][j] != 0)
                            {
                                matrix[t][j] = dumy_value;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                {
                    if(matrix[i][j] == dumy_value)
                    {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
    };
}