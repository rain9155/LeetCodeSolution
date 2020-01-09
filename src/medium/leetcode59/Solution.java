package medium.leetcode59;

/**
 * 螺旋矩阵 II:
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {

    /**
     * O(n):
     * 按层模拟：参考54题
     * 顺时针输入矩阵，就是按顺序把矩阵从外到内一层一层的输入元素
     * 每输入一层，起始点和边界都要做调整，起始点从（0，0）矩阵的左上角开始，边界从（n, n）开始
     */
    public int[][] generateMatrix(int n) {
        if(n <= 0) return null;
        int[][] ret = new int[n][n];
        int row = n;
        int col = n;
        int r = 0;
        int c = 0;
        int count = n * n;
        int num = 1;
        while (r < row && c < col && num <= count){
            for(int j = c; j < col; j++, num++){
                ret[r][j] = num;
            }
            for(int i = r + 1; i < row; i++, num++){
                ret[i][col - 1] = num;
            }
            for(int j = col - 2; j >= c; j--, num++){
                ret[row - 1][j] = num;
            }
            for(int i = row - 2; i > r; i--, num++){
                ret[i][c] = num;
            }
            r++;
            c++;
            row--;
            col--;
        }
        return ret;
    }

}
