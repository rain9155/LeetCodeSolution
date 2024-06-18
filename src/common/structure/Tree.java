package common.structure;

import common.node.TreeNode;

import java.util.*;
import java.util.List;

/**
 * 二叉树
 */
public class Tree {

    /**
     * todo: 给定数组初始化一颗二叉树
     */
    public TreeNode initTree(int[] nums){
        return null;
    }

    /**
     * 前序遍历一颗二叉树
     */
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
