#pragma once
#include <vector>

/**
 * 移除元素:
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
namespace Leetcode22
{
    class Solution 
    {
    public:
        int removeElement(std::vector<int>& nums, int val)
        {
            if(nums.size() == 0)
            {
                return 0;
            }
            int slow = 0;
            int fast = 0;
            while(fast < nums.size())
            {
                if(nums[fast] != val)
                {
                    nums[slow++] = nums[fast];
                }
                fast++;
            }
            return slow;
        }
    };
}