#pragma once
#include <vector>

/**
 * 搜索插入位置:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
namespace Leetcode35
{
    class Solution
    {
    public:
        /**
         * 二分查找法：O(logn)
         * 使用二分查找法查找第一个 >= target 的元素
         * 1、首先start = 0， end = len，终止条件(start < end)
         * 2、进行二分查找，如果找到等于 target 的元素，直接返回该元素下标；
         *                  如果 target > 找到的元素，就start = mid + 1，从 mid向后移动，尽量往右靠；
         *                  如果 target < 找到的元素，就end = mid，保持 mid原位，让start指针往右靠；
         * 3、最后由于start >= end跳出循环，返回start就行
         */
        int searchInsert(std::vector<int>& nums, int target)
        {
            int start = 0;
            int end = nums.size();
            while (start < end)
            {
                int mid = start + (end - start) / 2;
                if(target < nums[mid])
                {
                    end = mid;
                }
                else if(target > nums[mid])
                {
                    start = mid + 1;
                }
                else
                {
                    return mid;
                }
            }
            return start;
        }
    };
}