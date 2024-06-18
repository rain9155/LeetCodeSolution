package medium.leetcode304;

/**
 * 二维区域和检索 - 矩阵不可变:
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 *
 * 示例:
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * 说明:
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 *
 */

/**
 * 一维前缀和：
 * 参考303，初始化一个二维矩阵，二维矩阵的每一维，即每一行缓存[0, col]累加的和
 * 然后检索时对二维区域中的每一行计算子数组和，然后对每一行的子数组和计算总和
 */
public class NumMatrix {

    final int[][] datas;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            datas = null;
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        datas = new int[row][col + 1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                datas[i][j + 1] = datas[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(datas == null) return 0;
        int sum = 0;
        while (row1 <= row2){
            sum += datas[row1][col2 + 1] - datas[row1][col1];
            row1++;
        }
        return sum;
    }

}
