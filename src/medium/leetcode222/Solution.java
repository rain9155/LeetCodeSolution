package medium.leetcode222;

import common.struction.TreeNode;

/**
 * 完全二叉树的节点个数：
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * 输出: 6
 */
public class Solution {


    /**
     * O(n)
     * 依此访问每个节点，并统计个数
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * O(logn):
     * 利用完全二叉树的性质：它是一棵空树或者它的叶子节点只出在最后两层，若最后一层不满则叶子节点只在最左侧
     * 所以我们分别统计左右子树的高度，记为ld和rd，若：
     *  ld == rd，说明左子树是满二叉树，则左子树的节点个数为：2^ld - 1, 这样就不用遍历计算左子树的节点个数，而只需要遍历右子树
     *  ld != rd, 说明右子树是满二叉树，则右子树的节点个数为：2^rd - 1，同理，这样就不用遍历计算右子树的节点个数，而只需要遍历左子树
     * 这样每次只需要计算左子树或右子树的节点个数，就可以得出整个子树的节点个数
     */
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;

        int ld = getDepth(root.left);//得到左子树的高度
        int rd = getDepth(root.right);//得到右子树的高度

        if(ld == rd){//如果左子树的高度等于右子树的高度，说明左子树是满二叉树，则左子树的节点个数为：2^ld - 1

            //所以加上当前层的节点个数一共为2^ld - 1 + 1 = 2^ld
            //右子树是完全二叉树，继续对右子树递归计算节点个数，并加上2^ld
            return countNodes2(root.right) + (1 << ld);

        }else {//如果左子树的高度不等于右子树的高度，说明右子树是满二叉树，则右子树的节点个数为：2^rd - 1

            //所以加上当前层的节点个数一共为2^rd - 1 + 1 = 2^rd
            //左子树是完全二叉树，继续对左子树递归计算节点个数，并加上2^rd
            return countNodes2(root.left) + (1 << rd);

        }
    }

    private int getDepth(TreeNode root){
        int depth = 0;
        TreeNode cur = root;
        while (cur != null){
            depth++;
            cur = cur.left;
        }
        return depth;
    }

}
