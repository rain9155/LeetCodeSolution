#pragma once
#include <vector>

/**
 * 旋转数组:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
namespace Leetcode189
{
    class Solution
    {
    public:
        /**
         * 原地反转3次：
         * 第一次反转，把整个nums数组反转
         * 第二次反转，把nums中[0, k - 1]位置的元素反转
         * 第三次反转，把nums中[k, len]位置的元素反转
         */
        void rotate(std::vector<int>& nums, int k)
        {
            int len = nums.size();
            int shift = k % len;
            if(len == 0 || shift == 0)
            {
                return;
            }
            reverse(nums, 0, len - 1);
            reverse(nums, 0, shift - 1);
            reverse(nums, shift, len - 1);
        }

    private:
        void reverse(std::vector<int>& nums, int start, int end)
        {
            if(start < 0 || end > nums.size())
            {
                return;
            }
            while (start < end)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            
        }
    };
}