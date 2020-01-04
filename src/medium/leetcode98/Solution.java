package medium.leetcode98;

import common.node.TreeNode;

/**
 * 验证二叉搜索树:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution {

    Integer preVal = null;

    /**
     * 中序遍历：
     * 因为二叉搜索树中序遍历的过程就是升序的过程，所以如果在中序遍历的过程中发现某一个结点的值比上一个小，就说明这不是一颗合法的二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null){
            if(!isValidBST(root.left)) return false;
        }
        if(preVal != null && root.val <= preVal){
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }


}
