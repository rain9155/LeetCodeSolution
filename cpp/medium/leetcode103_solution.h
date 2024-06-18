#pragma once
#include <vector>
#include <queue>
#include <list>
#include "../common/struct.h"

using namespace Common;

/**
 * 二叉树的锯齿形层次遍历:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历，（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
namespace Leetcode103
{
    class Solution
    {
    public:
        /**
         * 迭代(层次遍历):
         * 思路和102题一样，用一个boolean值控制元素的放置方向
         */
        std::vector<std::vector<int>> zigzagLevelOrder(TreeNode* root)
        {
            std::vector<std::vector<int>> ret;
            if(root == nullptr)
            {
                return ret;
            }
            std::queue<TreeNode*> queue;
            queue.push(root);
            bool left = true;
            while (!queue.empty())
            {
                std::vector<int> list;
                int len = queue.size();
                for(int i = 0; i < len; i++)
                {
                    TreeNode* node = queue.front();
                    queue.pop();
                    if(left)
                    {
                        list.push_back(node->val);
                    }
                    else 
                    {
                        list.insert(list.begin(), node->val);
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
                ret.push_back(list);
                left = !left;
            }
            return ret;
        }
    };
}