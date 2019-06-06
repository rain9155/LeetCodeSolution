import medium.leetcode73.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(nums);
        for(int[] num : nums){
            for(int n : num){
                System.out.print(n);
            }
            System.out.println();
        }
    }
}
