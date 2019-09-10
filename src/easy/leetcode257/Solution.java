package easy.leetcode257;

import common.struction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Solution {

    /**
     * 递归：
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        binaryTreePath(root, "", ret);
        return ret;
    }

    private void binaryTreePath(TreeNode root, String temp, List<String> ret){
        if(root == null) return;
        temp += root.val;
        if(root.left == null && root.right == null){
            ret.add(temp);
            return;
        }
        temp += "->";
        if(root.left != null){
            binaryTreePath(root.left, temp, ret);
        }
        if(root.right != null){
            binaryTreePath(root.right, temp, ret);
        }
    }

}
