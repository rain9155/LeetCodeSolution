#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 相同的树:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
namespace Leetcode100
{
    class Solution
    {
    public:
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