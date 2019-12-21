package easy.leetcode111;

import common.struction.TreeNode;

/**
 * 二叉树的最小深度:
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class Solution {

    int min = Integer.MAX_VALUE;

    /**
     * 递归(dfs)：
     * 当遇到叶子节点时，就记录最小的深度
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        return min;
    }

    public void minDepth(TreeNode root, int depth) {
        if(root == null) return ;
        if(root.left == null && root.right == null){
            min = Math.min(min, depth);
        }
        minDepth(root.left, depth + 1);
        minDepth(root.right, depth + 1);
    }


    /**
     * 递归 + 后序遍历：
     * 后序遍历的特点是，当递归到当前结点时，它保证当前结点的左右子树已经遍历过了
     * 所以，在每次返回时，比较左右子树的高度，返回左右子树的最小高度 + 1给上一层
     * 这样当递归返回到根节点时，就能返回最小的高度
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int leftH = minDepth(root.left);
        int rightH = minDepth(root.right);
        if(leftH > 0 && rightH > 0){
            return Math.min(leftH, rightH) + 1;
        }
        return leftH > rightH ? leftH + 1 : rightH + 1;
    }

}
