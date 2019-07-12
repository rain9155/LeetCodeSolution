package easy.leetcode104;

import common.struction.TreeNode;

/**
 * 二叉树的最大深度:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 */
public class Solution {

    /**
     * 递归：深度优先遍历
     * 每一层加一，直到遇到空结点，返回0，最后取左右子树最大深度那个
     */
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node){
        if(node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

}