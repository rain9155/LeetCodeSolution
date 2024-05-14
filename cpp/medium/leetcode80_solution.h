#pragma once
#include <vector>

/**
 * 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 
 */
namespace Leetcode80
{
    class Solution
    {
    public:
        int removeDuplicates(std::vector<int>& nums)
        {
            if(nums.size() == 0)
            {
                return 0;
            }

            int p1 = 1;
            int p2 = 1;
            int count = 1;

            while (p2 < nums.size())
            {
                if(nums[p2] == nums[p2 -1])
                {
                    count++;
                }
                else
                {
                    count = 1;
                }
                if(count <= 2)
                {
                    nums[p1] = nums[p2];
                    p1++;
                }
                p2++;
            }

            return p1;
        }
    };
}