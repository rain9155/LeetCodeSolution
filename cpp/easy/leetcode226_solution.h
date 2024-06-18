#pragma once
#include "./common/struct.h"
#include <stack>

using namespace Common;

/**
 * 翻转一棵二叉树：
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
namespace Leetcode226
{
    class Solution
    {
    public:
        /**
         * 栈实现：
         * 每遍历到一个节点时，就交换它的左右子树，直到所有节点的左右子树都被交换
         */
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