package easy.leetcode226;

import common.struction.TreeNode;

/**
 * 翻转一棵二叉树：
 *
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution {

    /**
     * 递归：
     * 遍历这个树的所有非叶子节点，每当遍历到一个节点时，就交换它的左右子树，直到所有节点的左右子树都被交换
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
