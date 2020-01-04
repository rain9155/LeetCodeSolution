package medium.leetcode114;

import common.node.TreeNode;

/**
 * 二叉树展开为链表:
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Solution {

    private TreeNode lastNode = null;

    /**
     * 递归 + 前序遍历：
     * 用一个全局变量lastNode保存上一次遍历过的结点，然后每层递归都更新lastNode为当前遍历的TreeNode
     * 二叉树展开为链表的结点顺序就是前序遍历的过程，注意的是在每一层的递归中要暂时暂存一下右子树，因为在下一层递归中会被左子树覆盖
     */
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode copyRight = root.right;//暂存一下右子树，因为在下一层递归中会被左子树覆盖
        flatten(root.left);
        flatten(copyRight);
    }

}
