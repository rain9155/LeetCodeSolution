#pragma once
#include "../common/struct.h"
#include <queue>

using namespace Common;

/**
 * 对称二叉树:
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
namespace Leetcode101
{
    class Solution
    {
    public:
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