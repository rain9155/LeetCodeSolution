package medium.leetcode74;

/**
 * 搜索二维矩阵:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个整数 target，如果存在返回 true，否则返回false。
 * 
 * 该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
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
     * 两次二分查找：
     * 因为每一行的第一个元素都大于前一行的最后一个元素，所以二维数组的第一列是升序的
     * 所以对二维数组的第一列元素二分查找，找到最后一个 <= target的元素，然后在该元素所在行中二分查找目标值是否存在
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int rowIndex = binarySearchFirstCol(matrix, target);
        if(rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    private int binarySearchFirstCol(int[][] matrix, int target) {
        int left = -1;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(matrix[mid][0] <= target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean binarySearchRow(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] == target) {
                return true;
            }else if(row[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 一次二分查找法：O(lognm)
     * 把二维数组的下标转为一维数组的下标，然后对该一维数组的下标进行二分查找，转换关系是：[i, j] == j + i * n, n为二维数组的列数
     * 所以一开始初始化left = 0， right = n * m - 1, 则mid = (right + left) / 2, 根据转换关系推出 i = mid / n, j = mid % m
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;//0 + 0 * 0
        int right = m * n - 1;//3 + 2 * 4
        while (left <= right){
            int mid = left + (right - left) / 2;
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
