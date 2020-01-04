package medium.leetcode95;

import common.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II：
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class Solution {

    /**
     * DFS:
     * 利用一下查找二叉树的性质, 左子树的所有值小于根节点，右子树的所有值大于根节点。
     * 所以如果求 1...n 的所有可能。
     * 我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
     * 2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
     * 3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
     * 4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
     * ...
     * n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
     * 至于，[ 2 ... n ]的所有可能以及[ 4 ... n ]的所有可能以及其他情况的所有可能，可以递归利用上边的方法，把每个数字作为根节点
     * 最后在每一层的递归返回时，把所有可能的左子树和右子树组合起来即可。
     * 而如果是 [ ]，那就返回 null。
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> tempList = new ArrayList<>();//每一层的所有可能
        //null结点
        if(start > end){
            tempList.add(null);
        }
        for(int i = start; i <= end; i++){//每一层尝试每个数字i作为根节点
            List<TreeNode> leftTrees = generate(start, i - 1);//根结点i的左边的所有子树
            List<TreeNode> rightTrees = generate(i + 1, end);//根结点i右边的所有子树
            //组合左右两边的所有子树
            for(TreeNode leftRoot : leftTrees){
                for(TreeNode rightRoot : rightTrees){
                    //以数字i作为根结点
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    tempList.add(root);
                }
            }
        }
        return tempList;
    }

}
