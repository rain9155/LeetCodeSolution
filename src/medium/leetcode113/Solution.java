package medium.leetcode113;

import common.struction.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II:
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Solution {

    /**
     * 回溯算法：
     * 和112题的思路一样，只是在递归的过程中用一个list暂时保存所遍历过的路径的结点，当到达叶子结点并且sum==0时就加入结果的集合中
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        pathSum(ret, new ArrayList<>(), root, sum);
        return ret;
    }

    private void pathSum(List<List<Integer>> ret, List<Integer> path, TreeNode root, int sum){
        if(root == null) return;
        sum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == 0) ret.add(new ArrayList<>(path));
        pathSum(ret, path, root.left, sum);
        pathSum(ret, path, root.right, sum);
        path.remove(path.size() - 1);
    }

}
