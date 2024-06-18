#pragma once
#include <queue>
#include "./common/struct.h"

using namespace Common;

/**
 * 二叉树的最大深度:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 */
namespace Leetcode104
{
    class Solution
    {
    public:
        /**
         * bfs(层次遍历):
         * 记录树的层数
         */
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