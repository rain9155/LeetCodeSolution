package medium.leetcode378;

/**
 * 有序矩阵中第K小的元素:
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 */
public class Solution {

    /**
     * 参考; https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
     * 二分查找：
     * 1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
     * 2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
     * 3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
     * 4.若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
     * 5.因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right
     */
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];//找出矩阵中的最小数
        int right = matrix[row - 1][ col - 1];//找出矩阵的最大数
        while(left < right){
            int mid = (left + right) >>> 1;//找出[left, right]范围的中间数
            int count = getLessThanMid(matrix, mid);
            if(count < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    /**
     * 找出在matrix中 <=  num的数目
     */
    private int getLessThanMid(int[][] matrix, int num){
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;//从第一行开始
        int ret = 0;
        //统计到num的行
        while(i < row){
            //利用matrix的有序性，如果每一列的最后一个数比num小，结果就加col
            if(matrix[i][col - 1] < num){
                ret += col;
            }else{//从第一列开始逐个统计
                int j = 0;
                while(j < col && matrix[i][j] <= num){
                    ret++;
                    j++;
                }
            }
            i++;
        }
        return ret;
    }

}
