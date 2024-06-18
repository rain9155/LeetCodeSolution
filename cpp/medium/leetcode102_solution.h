#pragma once
#include <vector>
#include <queue>
#include "../common/struct.h"

using namespace Common;

/**
 * 二叉树的层次遍历:
 * 给定一个二叉树，返回其按层次遍历的节点值（即逐层地，从左到右访问所有节点）。
 * 
 * 示例:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
namespace Leetcode102
{
    class Solution
    {
    public:
        /**
         * 迭代(层次遍历):
         * 1、用一个队列保存每一层的结点数，然后把队列中每一层的的结点数添加进ret中
         * 2、在每一次的遍历中都把当前遍历的node的左右结点add进队列，这样直到队列为空
         */
        std::vector<std::vector<int>> levelOrder(TreeNode* root)
        {
            std::vector<std::vector<int>> ret;
            if(root == nullptr)
            {
                return ret;
            }
            std::queue<TreeNode*> queue;
            queue.push(root);
            while (!queue.empty())
            {
                std::vector<int> temp;
                int len = queue.size();
                for(int i = 0; i < len; i++)
                {
                    TreeNode* node = queue.front();
                    queue.pop();
                    temp.push_back(node->val);
                    if(node->left != nullptr)
                    {
                        queue.push(node->left);
                    }
                    if(node->right != nullptr)
                    {
                        queue.push(node->right);
                    }
                }
                ret.push_back(temp);
            }
            return ret;
        }
    };
}