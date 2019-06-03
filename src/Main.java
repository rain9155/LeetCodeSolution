import common.Utils;
import common.struction.ListNode;
import medium.leetcode63.Solution;
import common.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        System.out.println(solution.uniquePathsWithObstacles(nums));
    }
}
