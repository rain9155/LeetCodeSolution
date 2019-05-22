import common.List;
import medium.leetcode31.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 1};
        solution.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num + "  ");
        }
    }


}
