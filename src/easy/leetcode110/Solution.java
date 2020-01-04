package easy.leetcode110;

import common.node.TreeNode;

/**
 * 平衡二叉树:
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class Solution {

    /**
     * 递归：
     * 首先我们知道平衡二叉树是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树；
     * 我们可以使用一个获取树的高度的函数。然后递归比较左右子树是不是平衡二叉树且左右子树的高度不超过1即可。
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        int leftH = height(root.left);
        int rightH = height(root.right);
        return left && right && Math.abs(leftH - rightH) <= 1;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private boolean isBanlanced = true;

    /**
     * 递归 + 后序遍历：
     * 对求树的高度做一些变化，采取后序遍历的方式遍历二叉树的每一个结点
     * 在遍历每个结点的时候记录它的左右子树的高度度，通过比较每个结点的左右子树高度差判断该以该结点为根的子树是不是平衡的
     * 在每一层递归返回的时候根据左右子树的高度记录树的高度
     */
    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        height2(root);
        return isBanlanced;
    }

    private int height2(TreeNode root){
        if(root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        if(Math.abs(leftH - rightH) > 1) isBanlanced = false;
        return Math.max(leftH, rightH) + 1;
    }


}
