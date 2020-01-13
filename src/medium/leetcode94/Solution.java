package medium.leetcode94;

import common.node.ListNode;
import common.node.TreeNode;
import common.structure.Tree;

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
     * 基于栈的非递归实现(会修改原本的树结构):
     * 1、首先把根节点入栈，然后进入一个while循环
     * 2、如果当前节点的左节点不为空，就把左节点入栈，并把当前节点与左节点的连接置空(防止左节点重复入栈)
     * 3、如果当前节点的左节点为空，说明到树底了，就弹出当前节点，访问它，然后判断当前节点的右节点是否为空，不为空就把右节点入栈
     * 4、重复2、3直到栈为空
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(cur.left != null){
                stack.push(cur.left);
                cur.left = null;
            }else{
                cur = stack.pop();
                ret.add(cur.val);
                if(cur.right != null){
                    stack.push(cur.right);
                }
            }
        }
        return ret;
    }

    /**
     * 基于栈的非递归实现2(推荐):
     * 1、首先把根节点入栈
     * 2、然后从根节点开始，把每个节点的左节点入栈，直到树底
     * 3、然后依此访问栈顶的节点，如果栈顶节点有右节点，就把右节点入栈, 如果右节点有左节点，就从右节点开始，把每个节点的左节点入栈，直到树底
     * 4、重复3直到栈为空
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //从根节点开始，把每个节点的左节点入栈，直到树底
        TreeNode left = root.left;
        while (left != null){
            stack.push(left);
            left = left.left;
        }
        //然后依此访问栈顶的节点，如果栈顶节点有右节点，就把右节点入栈, 如果右节点有左节点，就从右节点开始，把每个节点的左节点入栈，直到树底
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ret.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
                TreeNode l = cur.right.left;
                while (l != null){
                    stack.push(l);
                    l = l.left;
                }
            }
        }
        return ret;
    }

}
