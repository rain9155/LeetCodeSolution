import medium.leetcode130.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] broad = {
                {'X','X', 'X'},
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
        };
        solution.solve(broad);
        for(int i = 0; i < broad.length; i++){
            System.out.println(Arrays.toString(broad[i]));
        }
    }
}
