#pragma once
#include "./common/struct.h"
#include <stack>

using namespace Common;

/**
 * 翻转一棵二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
namespace Leetcode226
{
    class Solution
    {
    public:
        TreeNode* invertTree(TreeNode* root)
        {
            if(root == nullptr)
            {
                return nullptr;
            }
            std::stack<TreeNode*> s;
            s.push(root);
            while (!s.empty())
            {
                TreeNode* node = s.top();
                s.pop();

                TreeNode* temp = node->left;
                node->left = node->right;
                node->right = temp;

                if(node->left != nullptr)
                {
                    s.push(node->left);
                }

                if(node->right != nullptr)
                {
                    s.push(node->right);
                }
            }
            return root;
        }
    };
}