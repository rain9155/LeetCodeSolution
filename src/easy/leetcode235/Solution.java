package easy.leetcode235;

import common.struction.TreeNode;

/**
 * 二叉搜索树的最近公共祖先:
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Solution {

    /**
     * 递归：
     * 两个节点的最近公共祖先一定会把两个节点分割成左右孩子节点的节点或最近公共祖先就是两个节点的其中一个
     * 所以我们可以利用二叉搜索树的特征：
     *      如果两个节点的值都比root节点的值小，那么它们的LCA一定在root的左子树上
     *      如果两个节点的值都比root节点的值大，那么它们的LCA一定在root的右子树上
     *      如果一个节点比root节点的值大或等于，一个节点比root节点值小或等于，那么这个root就是LCA，也就是最近的分割点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }
    }

    /**
     * 迭代：
     * 用迭代实现递归的逻辑
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curNode = root;
        while (curNode != null){
            if(p.val < curNode.val && q.val < curNode.val){
                curNode = curNode.left;
            }else if(p.val > curNode.val && q.val > curNode.val){
                curNode = curNode.right;
            }else {
                return curNode;
            }
        }
        return null;
    }

}
