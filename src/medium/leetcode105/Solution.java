package medium.leetcode105;

import common.Tree;
import common.struction.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
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
     * 首先看一下前序遍历是[3,9,20,15,7]，中序遍历是[9,3,15,20,7]
     * 1、根据前序遍历和后序遍历可以构造出一颗树，因为前序遍历的第一个结点一定是根结点，我们可以根据此根结点找到在中序遍历中的位置
     * 2、然后此根节点在中序遍历中的位置把中序遍历数组分为两部分，根节点的左边是根结点的左孩子个数，根结点的右边是根结点的右孩子个数，即[左孩子结点个数，根结点，右孩子结点个数]
     * 3、然后根据左孩子结点的个数，我们可以在前序遍历中找到根节点的右子树的根节点的位置(根节点位置 + 左孩子结点的个数 + 1)，而根节点的左子树的根节点就是，当前根结点在前序遍历中的位置的下一个（根节点位置 + 1）
     * 4、每一层递归都重复上述1、2、3步骤，直到inStart > inEnd即中序遍历的划分不满足条件
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return tree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode tree(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int val = preorder[preIndex];
        TreeNode treeNode = new TreeNode(val);
        int inLLen = 0;
        //这里要求出左孩子结点的个数inLLen，从而能求出右孩子结点的个数
        for(int i = inStart; i <= inEnd && inorder[i] != val; i++) inLLen++;
        //上面已经求出根节点的左孩子结点的个数，所以根节点的左子树的根结点在前序遍历的位置是preIndex + 1，而中序遍历的划分是[inStart, inStart + inLLen - 1]
        treeNode.left = tree(preorder, inorder, preIndex + 1, inStart , inStart + inLLen - 1);
        //上面已经求出根节点的左孩子结点的个数，所以根节点的右子树的根结点在前序遍历的位置是preIndex + inLLen + 1, 而中序遍历的划分是[inStart + inLLen + 1, inEnd]
        treeNode.right = tree(preorder, inorder, preIndex + inLLen + 1,inStart + inLLen + 1, inEnd);
        return treeNode;
    }

}
