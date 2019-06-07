package medium.leetcode74;

/**
 * 搜索二维矩阵:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Solution {

    /**
     * O(nm)
     * 二分查找法：
     * 把二维数组的下标转为一维数组的下标，然后对该一维数组的下标进行二分查找
     * 转换关系是：[i, j] == j + i * n, 为二维数组的列数
     * 所以一开始初始化left = 0， right = n * m - 1, 则mid = (right + left) / 2, 根据转换关系推出 i = mid / n, j = mid % m
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;//0 + 0 * 0
        int right = m * n - 1;//3 + 2 * 4
        while (left <= right){
            int mid = (right + left) / 2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

}
