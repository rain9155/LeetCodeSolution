package common.structure;

import common.node.TreeNode;

import java.util.*;
import java.util.List;

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

    private TreeNode createBiTree(TreeNode root, int[] nums, int index){
        return root;
    }

    public List<Integer> preorderTree(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        traversal(root, ret);
        return ret;
    }

    private void traversal(TreeNode node, List<Integer> ret) {
        if(node == null){
            return;
        }
        ret.add(node.val);
        if(node.left != null){
            traversal(node.left, ret);
        }
        if(node.right != null){
            traversal(node.right, ret);
        }
    }

}
