#pragma once
#include "../common/struct.h"
#include <queue>

using namespace Common;


/**
 * 对称二叉树:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
namespace Leetcode101
{
    class Solution
    {
    public:
        /**
         * 迭代：
         * 如果一棵树是对称二叉树，那么它的左子树和右子树是对称的
         * 如果左子树和右子树对称，就等于左子树的根与右子树的根相等并且左子树的左子树与右子树的右子树、左子树的右子树与右子树的左子树对称
         */
        bool isSymmetric(TreeNode* root)
        {
            if(root == nullptr)
            {
                return true;
            }
            std::queue<TreeNode*> q;
            q.push(root->left);
            q.push(root->right);
            while (!q.empty())
            {
                TreeNode* node1 = q.front();
                q.pop();
                TreeNode* node2 = q.front();
                q.pop();
                if(node1 == nullptr && node2 == nullptr)
                {
                    continue;
                }
                if(node1 == nullptr || node2 == nullptr)
                {
                    return false;
                }
                if(node1->val != node2->val)
                {
                    return false;
                }
                q.push(node1->left);
                q.push(node2->right);
                q.push(node1->right);
                q.push(node2->left);
            }
            return true;
        }
    };
}