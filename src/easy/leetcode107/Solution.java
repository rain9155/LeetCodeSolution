package easy.leetcode107;

import common.node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的层次遍历 II:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution {

    List<List<Integer>> ret = new ArrayList<>();

    /**
     * bfs(层次遍历)：
     * 思路和102题的层次遍历一样，这里只是把最后层次遍历的结果逆序一遍
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return ret;
        orderBottom(root, 0);
        Collections.reverse(ret);
        return ret;
    }

    private void orderBottom(TreeNode root, int lever){
        if(ret.size() <= lever){
            ret.add(new ArrayList<>());
        }
        ret.get(lever).add(root.val);
        if(root.left != null){
            orderBottom(root.left, lever + 1);
        }
        if(root.right != null){
            orderBottom(root.right, lever + 1);
        }
    }

    //树的层次遍历可以使用队列实现，参考104题

}
