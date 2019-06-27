import medium.leetcode93.Solution;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
         List<String> ret = solution.restoreIpAddresses("25525511135");
         for(String s : ret){
             System.out.println(s);
         }
    }
}
