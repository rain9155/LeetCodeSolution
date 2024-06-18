package easy.leetcode530;

import common.node.*;

/**
 * 二叉搜索树的最小绝对差:
 * 给你一个二叉搜索树的根节点root ，返回树中任意两不同节点值之间的最小差值, 差值是一个正数，其数值等于两值之差的绝对值。
 * 
 * 示例 1:
 *      4
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 
 * 示例 2：
 *      1
 *     / \
 *    0   48
 *       /  \
 *      12  49
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class Solution {

    int ret;
    int pre;

    /**
     * 递归(中序遍历)：
     * 二叉搜索树的中序遍历结果为一个升序数组，问题转化为求升序数组中两个元素的最小差值，升序数组中两个元素的最小差值为两两相邻的元素差值的最小值
     * 可以在中序遍历二叉搜索树时边遍历边更新结果，用pre保存上一个遍历过的值，当遍历到当前结点cur时，用cur的值减去pre的值求出差值，然后和先前保存的结果比较取最小值
     */
    public int getMinimumDifference(TreeNode root) {
        ret = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        if(pre == -1) {
            pre = node.val;
        }else {
            ret = Math.min(ret, node.val - pre);
            pre = node.val;
        }
        dfs(node.right);
    }
}
