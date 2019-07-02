package easy.leetcode101;

import common.struction.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树:
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Solution {

    /**
     * 递归：
     * 如果一棵树是对称二叉树，那么它的左子树和右子树是对称的
     * 如果左子树和右子树对称，就等于左子树的根与右子树的根相等并且左子树的左子树与右子树的右子树、左子树的右子树与右子树的左子树对称，就这样递归下去
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && symmetric(t1.left, t2.right) && symmetric(t1.right, t2.left);
    }

    /**
     * 迭代：
     */
    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

}
