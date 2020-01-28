package medium.leetcode114;

import common.node.TreeNode;

/**
 * 二叉树展开为链表:
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Solution {

    private TreeNode lastNode = null;

    /**
     * 递归 + 前序遍历：
     * 二叉树展开为链表的结点顺序就是前序遍历的过程,所以我们可以在前序遍历的过程中把二叉树连成链表
     * 1、用一个全局变量lastNode保存上一次遍历过的结点，如果lastNode不为空，就把lastNode的right指针指向当前节点，并把left指针置空
     * 2、每一层递归都更新lastNode为当前遍历的TreeNode，并暂时暂存一下右子树，因为在下一层递归中会被左子树覆盖
     * 3、然后分别递归遍历当前节点的左子树和暂存的右子树
     */
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode copyRight = root.right;//暂存一下右子树，因为在下一层递归中会被左子树覆盖
        flatten(root.left);
        flatten(copyRight);
    }

    /**
     * 递归 + 后序遍历:
     * 当后序遍历的递归返回时，当前节点的左子树和右子树已经分别形成了一条链表结构，所以我们只需要把这两条链表连接起来
     * 1、分别递归遍历当前节点的左子树和右子树，直到叶子节点
     * 2、当递归返回时，我们暂存当前节点的右子树，然后把当前节点的right指针指向左子树，并置空left指针
     * 3、这时当前节点的右子树已经形成了链表形状，我们从右子树的根节点开始遍历，一直到链表的底部，然后把链表底部与暂存的右子树相连
     */
    public void flatten2(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = temp;
    }

}
