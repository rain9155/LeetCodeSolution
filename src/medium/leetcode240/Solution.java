package medium.leetcode240;

/**
 * 搜索二维矩阵 II:
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class Solution {

    /**
     * O(n + m)
     * 找一个特殊的起点，减少搜索范围：
     * 我们以矩阵的右上角的元素作为起点
     * 1、每次比较右上角元素和target的大小，如果等于直接返回
     * 2、如果右上角元素 > target，说明target不在右上角元素所在的列，在右上角元素的左边，这时可以col--，剔除右上角元素所在的列，重复1
     * 3、如果右上角元素 < target，说明target不在右上角元素所在的行，在右上角元素的下边，这时可以row--，剔除右上角元素所在的行，重复1
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

}
