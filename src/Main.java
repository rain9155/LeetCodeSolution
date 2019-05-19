import easy.leetcode66.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9, 9, 9};
        nums = solution.plusOne(nums);
        for(int num : nums){
            System.out.print(num + "  ");
        }
    }


}
