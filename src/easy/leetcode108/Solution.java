package easy.leetcode108;

import common.struction.TreeNode;

/**
 * 将有序数组转换为二叉搜索树：
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution {

    /**
     * 分治法：
     * 因为要构造一颗二叉搜索树，所以左右两颗子树的高度差不能超过1，并且左子树的结点值都小于根结点，右子树的结点值都大于根节点
     * 同时又因为数组是升序的，所以只要每次把数组一分为二，就能满足二叉搜索树的性质，然后递归分别构造左右两颗子树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return arrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBST(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = arrayToBST(nums, start, mid - 1);
        root.right = arrayToBST(nums, mid + 1, end);
        return root;
    }

}
