import medium.leetcode47.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> ret = solution.permuteUnique(nums);
        for(List<Integer> list : ret){
            System.out.println(list);
        }
    }


}
