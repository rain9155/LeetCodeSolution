package medium.leetcode48;

/**
 * 旋转图像:
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 
 * 示例 2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Solution {

    /**
     * 使用额外的空间：O（n^2）
     * 从上到下的每一行的放到从左到右的每一列
     */
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int n = matrix.length;
        int[][] clone = matrix.clone();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[j][n - i - 1] = clone[i][j];
            }
        }
    }

    /**
     * 原地修改：O（n^2）
     * 先对矩阵进行转置，即将矩阵的行和列进行交换
     * 然后对每一行进行翻转，即将每一行的元素顺序进行翻转
     */
    public void rotate2(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return;

        int n = matrix.length;

        //转置
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][j] = temp;
            }
        }

        //翻转
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * 找规律：O（n^2）
     *                  (i,j)
     *  (n -j-1, i)                 (j, n-i-1)
     *              (n-i-1, n-j-1)
     * 就是上面四个索引号上的数交换.
     */
    public void rotate3(int[][] matrix) {

        if(matrix.length == 0 || matrix.length != matrix[0].length) return;

        int n = matrix.length;

        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }

}
