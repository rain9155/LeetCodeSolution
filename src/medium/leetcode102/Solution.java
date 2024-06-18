package medium.leetcode102;

import common.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历:
 * 给定一个二叉树，返回其按层次遍历的节点值（即逐层地，从左到右访问所有节点）。
 * 
 * 示例:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution {

    List<List<Integer>> ret = new ArrayList<>();//ret的长度就是目前保存的最大层数

    /**
     * 递归(前序遍历)：
     * 1、逐层遍历，从左到右，用一个ret集合保存每层的遍历结果，ret的长度就是目前保存的最大层数
     * 2、用一个lever追踪当前遍历到哪一层，如果lever比ret的长度大，说明lever层还没被创建，就创建一个集合存进ret，后续用lever为索引取出当前层的集合，把当前元素保存进集合
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return ret;
        traversal(root, 0);
        return ret;
    }

    public void traversal(TreeNode treeNode, int level){
        if(ret.size() <= level){
            ret.add(new ArrayList<>());
        }
        ret.get(level).add(treeNode.val);
        if(treeNode.left != null){
            traversal(treeNode.left, level + 1);
        }
        if(treeNode.right != null){
            traversal(treeNode.right, level + 1);
        }
    }

    /**
     * 迭代(层次遍历):
     * 1、用一个队列保存每一层的结点数，然后把队列中每一层的的结点数添加进ret中
     * 2、在每一次的遍历中都把当前遍历的node的左右结点add进队列，这样直到队列为空
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lever = 0;
        while (!queue.isEmpty()){
            if(ret.size() <= lever){
                ret.add(new ArrayList<>());
            }
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                ret.get(lever).add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            lever++;
        }
        return ret;
    }

}
