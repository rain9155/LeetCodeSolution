#pragma once
#include <queue>
#include "./common/struct.h"

using namespace Common;

/**
 * 二叉树的最大深度:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
namespace Leetcode104
{
    class Solution
    {
    public:
        int maxDepth(TreeNode* root)
        {
            if(root == nullptr)
            {
                return 0;
            }
            std::queue<TreeNode*> queue;
            queue.push(root);
            int depth = 0;
            while (queue.size() > 0)
            {
                int size = queue.size();
                for(int i = 0; i < size; i++)
                {
                    TreeNode* node = queue.front();
                    queue.pop();
                    if(node->left != nullptr)
                    {
                        queue.push(node->left);
                    }
                    if(node->right != nullptr)
                    {
                        queue.push(node->right);
                    }
                }
                depth++;
            }
            return depth;
        }
    };
}