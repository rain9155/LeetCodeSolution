package medium.leetcode230;

import common.struction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第K小的元素:
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Solution {


    /**
     * 中序遍历 + List：
     * 中序遍历的过程中保存遍历的元素到List中，当遍历完成时，List保存的是二叉搜索树中所有元素的有序集合
     * 所以最终结果只要返回List.get(k - 1)，就能得到二叉搜索树中第k小的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tempList = new ArrayList<>();
        helper(root, tempList);
        return tempList.get(k - 1);
    }

    private void helper(TreeNode root, List<Integer> tempList){
        if(root == null) return;
        helper(root.left, tempList);
        tempList.add(root.val);
        helper(root.right, tempList);
    }

    int ret;
    int order;

    /**
     * 中序遍历 + 一个常数保存结果：
     * 一开始把k赋值给order，然后在中序遍历的过程中，每遍历一个元素就把order减一，这样当order等于1时，代表遍历到二叉搜索树中第k小的元素
     * 所以这时就用结果用ret保存起来，然后把order置为无效，提前中止遍历
     */
    public int kthSmallest2(TreeNode root, int k) {
        order = k;
        helper(root);
        return ret;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(order == 1){
            ret = root.val;
            order = -1;
            return;
        }
        order--;
        helper(root.right);
    }

    /**
     * 利用二叉搜索树的性质：
     * root 大于左子树，小于右子树
     * 如果左子树的节点数目等于 k-1，那么 root 就是结果，直接返回
     * 否则如果左子树节点数目小于 k-1，那么结果必然在右子树，递归在右子树继续搜索
     * 否则如果左子树的节点数目大于 k-1，那么结果必然在左子树，递归在左子树继续搜索
     *
     */
    public int kthSmallest3(TreeNode root, int k) {
        if(root == null) return 0;
        int lcount = getNodeCount(root.left);
        if(lcount == k - 1) return root.val;
        else if(lcount < k - 1) return kthSmallest3(root.right, k);
        else  return kthSmallest3(root.left, k);
    }

    private int getNodeCount(TreeNode root){
        if(root == null) return 0;
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

}
