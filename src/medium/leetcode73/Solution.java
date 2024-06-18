package medium.leetcode73;

/**
 * 矩阵置零:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
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
 *
 * 进阶:
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution {

    /**
     * 使用额外的空间：O(mn)
     * 1、首先创建一个和matrix一样大小的二维数组temp，然后把matrix复制给temp
     * 2、遍历matrix，当遇到matrix[i][j]等于0时，就把temp的第i行和第j列的元素都置为0
     * 3、最后把temp复制给matrix
     */
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] temp = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                temp[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    int t = 0;
                    while(t < c){
                        temp[i][t++] = 0;
                    }
                    t = 0;
                    while(t < r){
                        temp[t++][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }


    /**
     * 原地算法：O(nm(n + m))
     * 1、遍历原始矩阵，如果发现如果某个元素 matrix[i][j] 为 0， 我们将第 i 行和第 j 列的所有非零元素设成很大的负虚拟值
     * 2、最后，我们遍历整个矩阵将所有等于虚拟值的元素设为 0。
     */
    public void setZeroes2(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(matrix[i][j] == 0){
                    int t = 0;
                    while(t < c){
                        if(matrix[i][t] != 0){
                            matrix[i][t] = -100000;
                        }
                        t++;
                    }
                    t = 0;
                    while(t < r){
                        if(matrix[t][j] != 0){
                            matrix[t][j] = -100000;
                        }
                        t++;
                    }
                }
            }
        }
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(matrix[i][j] == -100000){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 原地算法：O(nm)
     * 1、把matrix的第一行和第一列留出来，然后记录第一行和第一列是否会全为0，从第二行和第二列开始遍历
     * 2、每matrix[i][j] = 0时，就把第一行的第j列置为0，第一列第i行置为0
     * 3、当matrix遍历完后，分别遍历matrix的第一行或第一列，如果为0，就把这一行或这一列置为0
     * 4、如果第一行或第一列全为0，就把第一行和第一列置为0
     */
    public void setZeroes3(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        //记录第一行和第一列是否会全为0
        for(int j = 0; j < c; j++){
            if(matrix[0][j] == 0){
                isFirstRowZero = true;
            }
        }
        for(int i = 0; i < r; i++){
            if(matrix[i][0] == 0){
                isFirstColZero = true;
            }
        }
        //每matrix[i][j] = 0时，就把第一行的第j列置为0，第一列第i行置为0
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //如果matrix的第一行或第一列为0，就把这一行或这一列置为0
        for(int j = 1; j < c; j++){
            if(matrix[0][j] == 0){
                int i = 0;
                while (i < r){
                    matrix[i++][j] = 0;
                }
            }
        }
        for(int i = 1; i < r; i++){
            if(matrix[i][0] == 0){
                int j = 0;
                while (j < c){
                    matrix[i][j++] = 0;
                }
            }
        }
        //如果第一行或第一列全为0，就把第一行和第一列置为0
        if(isFirstRowZero){
            for(int j = 0; j < c; j++){
                matrix[0][j] = 0;
            }
        }
        if(isFirstColZero){
            for(int i = 0; i < r; i++){
                matrix[i][0] = 0;
            }
        }

    }


}
