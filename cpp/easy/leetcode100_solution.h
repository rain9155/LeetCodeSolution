#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 相同的树:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *         [1,2,3],   [1,2,3]
 * 输出: true
 * 
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *         [1,2],     [1,null,2]
 * 输出: false
 * 
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *         [1,2,1],   [1,1,2]
 * 输出: false
 */
namespace Leetcode100
{
    class Solution
    {
    public:
        /**
         * 递归比较左右子树，如果出现不相等的情况就返回false
         */
        bool isSameTree(TreeNode* p, TreeNode* q) 
        {
            if(p != nullptr && q != nullptr && p->val == q->val)
            {
                return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
            }
            else if(p == nullptr && q == nullptr)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    };
}