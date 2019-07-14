import common.Tree;
import common.struction.TreeNode;
import medium.leetcode127.Solution;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        List<String> list = new ArrayList<>(){{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        solution.ladderLength("hit", "cog", list);
    }
}
