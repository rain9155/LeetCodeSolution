#pragma once
#include <vector>
#include <queue>
#include "../common/struct.h"

using namespace Common;

/**
 * 二叉树的右视图:
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
namespace Leetcode199
{
    class Solution 
    {
    public:
        /**
         * 广度优先遍历：
         * 把每一层的结点放入队列中，然后取出每一层的结点的最后一个放入结果中
         */
        std::vector<int> rightSideView(TreeNode* root)
        {
            std::vector<int> ret;
            if(root == nullptr)
            {
                return ret;
            }
            std::queue<TreeNode*> queue;
            queue.push(root);
            while (!queue.empty())
            {
                int size = queue.size();
                for(int i = 0; i < size; i++)
                {
                    TreeNode* node = queue.front();
                    queue.pop();
                    if(i == size - 1)
                    {
                        ret.push_back(node->val);
                    }
                    if(node->left != nullptr)
                    {
                        queue.push(node->left);
                    }
                    if(node->right != nullptr)
                    {
                        queue.push(node->right);
                    }
                }
            }
            return ret;
        }
    };
}