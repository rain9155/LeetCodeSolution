package medium.leetcode106;

import common.node.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution {

    /**
     * 递归：
     * 思路和105一样：
     * 首先105的是先序遍历和中序遍历构造一颗二叉树，本题是后序遍历和中序遍历构造一颗二叉树，后序遍历的思路和先序遍历的思路是相反的
     * 1、所以后序遍历的最后一个结点一定是根节点，我们可以根据此根结点找到在中序遍历中的位置
     * 2、然后此根节点在中序遍历中的位置把中序遍历数组分为两部分，根节点的左边是根结点的左孩子个数，根结点的右边是根结点的右孩子个数，即[左孩子结点个数，根结点，右孩子结点个数]
     * 3、然后根据右孩子结点的个数，我们可以在后序遍历中找到根节点的左子树的根节点的位置(根节点位置 - 右孩子结点的个数 - 1)，而根节点的右子树的根节点就是，当前根结点在后序遍历中的位置的上一个（根节点位置 - 1）
     * 4、每一层递归都重复上述1、2、3步骤，直到inStart > inEnd即中序遍历的划分不满足条件
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        return tree(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode tree(int[] postorder, int[] inorder, int postIndex, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int val = postorder[postIndex];
        TreeNode treeNode = new TreeNode(val);
        int inLLen = 0;
        for(int i = inStart; i <= inEnd && inorder[i] != val; i++) inLLen++;
        int inRLen = inEnd - inStart - inLLen;//这次求根结点的右孩子个数
        //构造右子树
        treeNode.right = tree(postorder, inorder, postIndex - 1,inEnd - inRLen + 1, inEnd);
        //构造左子树
        treeNode.left = tree(postorder, inorder, postIndex - inRLen - 1, inStart , inEnd - inRLen - 1);
        return treeNode;
    }

}
