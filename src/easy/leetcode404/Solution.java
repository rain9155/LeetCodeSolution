package easy.leetcode404;

import common.struction.TreeNode;

/**
 * 左叶子之和:
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Solution {


    /**
     * 递归：
     * 在递归的过程中，用一个Boolean标志当前是左子树，还是右子树，当递归到叶子时，返回左叶子的数值给上一层累加
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        if(root.left == null && root.right == null && isLeft){
            return root.val;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}
