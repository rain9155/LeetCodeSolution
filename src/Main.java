import common.Utils;
import medium.leetcode78.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ret = solution.subsets(new int[]{1, 2, 3});
        for(List<Integer> list : ret){
            for(Integer num : list){
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
}
