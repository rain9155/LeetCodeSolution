#pragma once
#include <vector>

/**
 * 在排序数组中查找元素的第一个和最后一个位置:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target，找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
namespace Leetcode34
{
    class Solution
    {
    public:
        /**
         * 改造的二分查找法：O(logn)
         * 使用二分查找法，如果找到了，就从找到的位置开始向前循环，找target的出现第一个位置，
         * 然后从找到的位置开始向后循环，找target出现的最后一个位置，如果找不到返回{-1， -1}
         */
        std::vector<int> searchRange(std::vector<int>& nums, int target)
        {
            std::vector<int> ret = {-1, -1};
            if(nums.empty())
            {
                return ret;
            }
            int left = 0;
            int right = nums.size() - 1;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target)
                {
                    int p1 = mid;
                    while (p1 > 0 && nums[p1 - 1] == target)
                    {
                        p1--;
                    }
                    int p2 = mid;
                    while (p2 < nums.size() - 1 && nums[p2 + 1] == target)
                    {
                        p2++;
                    }
                    ret = {p1, p2};
                    return ret;
                }
                else if(nums[mid] > target)
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            return ret;
        }
    };
}