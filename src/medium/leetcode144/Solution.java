package medium.leetcode144;

import common.node.TreeNode;
import common.structure.Tree;

import java.util.*;

/**
 * 二叉树的前序遍历:
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {

    /**
     * 递归实现：
     */
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        preTraversal(root, ret);
        return ret;
    }

    private void preTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }

    /**
     * 基于栈的非递归实现：
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if(treeNode.right != null) stack.add(treeNode.right);
            if(treeNode.left != null) stack.add(treeNode.left);
        }
        return list;
    }

}
