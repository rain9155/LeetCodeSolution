package common;

import common.struction.TreeNode;

/**
 * 树
 */
public class Tree {

    public TreeNode initBiTree(int[] nums){
        if(nums == null || nums.length == 0) return null;
        TreeNode t = new TreeNode(nums[0]);
        createBiTree(t, nums, 0);
        int len = nums.length;
        return t;
    }

    private TreeNode createBiTree(TreeNode node, int[] nums, int index){
        return node;
    }

}
