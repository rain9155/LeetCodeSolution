package medium.leetcode54;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵:
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution {

    /**
     * O(n)
     * 按层模拟：
     * 顺时针输出矩阵，就是按顺序把矩阵从外到内一层一层的输出元素
     * 每输出一层，起始点和边界都要做调整，起始点从（0，0）矩阵的左上角开始，边界从（m, n）开始
     * 要注意当最内层只有一行元素时，要跳过按行递减和按列递减的循环
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return ret;
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        //从左上角开始
        int r = 0;
        int c = 0;
        while (r < n && c < m){
            for(int j = c;j < n; j++){//固定行，移动列, 列递增
                ret.add(matrix[r][j]);
            }
            for (int i = r + 1; i < m; i++){//固定列，移动行，行递增
                ret.add(matrix[i][n - 1]);
            }
            //当次外层只剩下一条边时，跳过
            if(r < m - 1 && c < n - 1){
                for(int j = n - 2;j >= c; j--){//固定行，移动列, 列递减
                    ret.add(matrix[m - 1][j]);
                }
                for (int i = m - 2; i > r; i--){//固定列，移动行，行递减
                    ret.add(matrix[i][c]);
                }
            }
            //调整起始点和边界
            r++;
            c++;
            n--;
            m--;
        }

        return ret;
    }

}
