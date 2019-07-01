import common.Tree;
import common.struction.TreeNode;
import medium.leetcode95.Solution;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Tree tree = new Tree();
        List<TreeNode> trees = solution.generateTrees(3);
        for(TreeNode node : trees){
            System.out.println(tree.preorderTree(node));
        }
    }
}
