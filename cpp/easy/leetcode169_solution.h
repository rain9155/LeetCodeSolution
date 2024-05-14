#pragma once
#include <vector>

/**
 * 求众数:
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
namespace Leetcode169
{
    class Solution
    {
    public:
        int majorityElement(std::vector<int>& nums)
        {
            int count = 0;
            int num = 0;
            for(int i = 0; i < nums.size(); i++)
            {
                if(count == 0)
                {
                    num = nums[i];
                }
                if(num == nums[i])
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
            return num;
        }
    };
}