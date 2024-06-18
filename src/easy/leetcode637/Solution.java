package easy.leetcode637;

import java.util.*;
import common.node.*;;

/**
 * 二叉树的层平均值：
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
 * 与实际答案相差 10-5 以内的答案可以被接受。
 * 
 * 示例：
 *      3
 *     /  \
 *    9   20
 *       /  \
 *      15   7
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 */
public class Solution {

    /**
     * 广度优先遍历：
     * 把每一层的结点放入队列中，然后取出每一层的结点计算平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0;
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(sum / len);
        }
        return ret;
    }
}
