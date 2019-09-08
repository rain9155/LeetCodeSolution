package medium.leetcode236;

import common.struction.TreeNode;

/**
 * 二叉树的最近公共祖先:
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Solution {

    /**
     * 递归：
     * 参考235，我们以root为递归起点分别从左右子树查找p、q：
     *          如果找到了那么root就是LCA
     *          如果在左子树找不到p，那么p就在右子树，则LCA在右子树，返回右子树的结果
     *          如果在右子树找不到q，那么q就在左子树，则LCA在左子树，返回左子树的结果
     *          如果左右子树都找不到p、q，那么就没有LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){//root刚好是分割点，返回root
            return root;
        }else if(left != null){//分割点在左子树
            return left;
        }else if(right != null){//分割点在右子树
            return right;
        }else {//找不到分割点
            return null;
        }
    }

}
