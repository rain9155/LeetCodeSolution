import common.Utils;
import common.struction.ListNode;
import medium.leetcode64.Solution;
import common.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(nums));
    }
}
