package easy.leetcode112;

import common.node.TreeNode;

/**
 * 路径总和:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution {


    /**
     * 递归：
     * 首先路径和是根节点到叶子结点的上所有节点值相加，然后叶子就是左右两颗子树都为空
     * 所以我们采用先序遍历，在每一次的遍历中，先访问根结点，然后用当前sum减去根节点的权值，然后判断当前结点是否是叶子节点并且sum是否等于零，如果sum == 0，就返回true
     * 然后按照同样的规则分别访问根节点的左右子树
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
