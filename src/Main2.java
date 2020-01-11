import common.Utils;
import medium.leetcode73.Solution;

public class Main2 {

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        Utils.printMartix(matrix);
        solution.setZeroes2(matrix);
        Utils.printMartix(matrix);
    }

}
