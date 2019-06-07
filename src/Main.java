import common.Utils;
import medium.leetcode75.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        Utils.printNums(nums);
    }
}
