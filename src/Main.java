import medium.leetcode49.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = solution.groupAnagrams(strs);
        for(List<String> list : ret){
            System.out.println(list);
        }
    }


}
