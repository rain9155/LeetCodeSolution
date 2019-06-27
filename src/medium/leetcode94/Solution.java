package medium.leetcode94;

import common.struction.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class Solution {

    /**
     * 递归实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversal(root, ret);
        return ret;
    }

    private void traversal(TreeNode node, List<Integer> ret) {
        if(node == null) return;
        if(node.left != null){
            traversal(node.left, ret);
        }
        ret.add(node.val);
        if(node.right != null){
            traversal(node.right, ret);
        }
    }

    /**
     * 基于栈的非递归实现
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }

}
