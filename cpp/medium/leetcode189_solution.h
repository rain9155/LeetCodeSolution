#pragma once
#include <vector>

/**
 * 旋转数组:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
namespace Leetcode189
{
    class Solution
    {
    public:
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