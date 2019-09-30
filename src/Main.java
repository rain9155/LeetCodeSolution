import common.Utils;
import medium.leetcode324.Solution;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 1, 1, 6};
        solution.wiggleSort(nums);
        Utils.printNums(nums);
    }
}
