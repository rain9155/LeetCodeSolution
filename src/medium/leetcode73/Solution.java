package medium.leetcode73;

/**
 * 矩阵置零:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 示例 1:
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution {

    /**
     * O(nm(n + m))：空间换时间
     * 遍历原始矩阵，如果发现如果某个元素 matrix[i][j] 为 0
     * 我们将第 i 行和第 j 列的所有非零元素设成很大的负虚拟值（比如说 -1000000）
     * 最后，我们遍历整个矩阵将所有等于虚拟值（常量在代码中初始化为 MODIFIED）的元素设为 0。
     */
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;//行
        while (r < m){
            int c = 0;//列
            while (c < n){
                if(matrix[r][c] == 0){
                    for(int j = 0; j < n; j++){
                       if(matrix[r][j] != 0){
                           matrix[r][j] = -100000;
                       }
                    }
                    for(int i = 0; i < m; i++){
                        if(matrix[i][c] != 0){
                            matrix[i][c] = -100000;
                        }
                    }
                }
                c++;
            }
            r++;
        }
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(matrix[i][j] == -100000){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
