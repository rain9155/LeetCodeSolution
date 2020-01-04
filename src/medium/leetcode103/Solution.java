package medium.leetcode103;

import common.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution {

    List<List<Integer>> ret = new ArrayList<>();

    /**
     * 递归：广度优先遍历
     * 思路和102题一样，每一层的遍历都是从左往右，不同的是在每一层的遍历中
     * 如果是偶数层，从左往右放元素，add到当前层集合的最后面，如果是奇数层，从右往左放，add到集合的第一个位置
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ret;
        leverOrder(root, 0);
        return ret;
    }

    private void leverOrder(TreeNode treeNode, int lever){
        if(ret.size() <= lever){
            ret.add(new ArrayList<>());
        }
        if(lever % 2 == 0) ret.get(lever).add(treeNode.val);//偶数层，从左往右放
        else ret.get(lever).add(0, treeNode.val);//奇数层，从右往左放
        if(treeNode.left != null) leverOrder(treeNode.left, lever + 1);
        if(treeNode.right != null) leverOrder(treeNode.right, lever + 1);
    }

}
