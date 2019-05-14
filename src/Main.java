import easy.leetcode26.Solution;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int len = solution.removeDuplicates2(nums);
        System.out.println(len);
        for(int i = 0; i < len; i++){
            System.out.print(nums[i]  + ", ");
        }
    }


}
