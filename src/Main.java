import medium.leetcode134.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1,2,3,4,5,5,70};
        int[] cost = {2,3,4,3,9,6,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
