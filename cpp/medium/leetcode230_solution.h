#pragma once
#include "../common/struct.h"

using namespace Common;

/**
 * 二叉搜索树中第K小的元素:
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
namespace Leetcode230
{
    class Solution
    {
    public:
        /**
         * 中序遍历：
         * 在中序遍历的过程中，每遍历一个元素就把k减一，这样当k等于1时，代表遍历到二叉搜索树中第k小的元素
         * 所以这时就用结果用ret保存起来，然后把k置为无效，提前中止遍历
         */
        int kthSmallest(TreeNode* root, int k)
        {
            int ret = -1;
            dfs(root, k, ret);
            return ret;
        }

        void dfs(TreeNode* root, int& k, int& ret)
        {
            if(root == nullptr || k < 0)
            {
                return;
            }
            dfs(root->left, k, ret);
            if(k == 1)
            {
                ret = root->val;
                k = -1;
                return;
            }
            k--;
            dfs(root->right, k, ret);
        }
    };
}