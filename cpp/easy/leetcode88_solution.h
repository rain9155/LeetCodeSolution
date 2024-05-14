#pragma once
#include <vector>

/**
 * 合并两个有序数组:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
namespace Leetcode88
{
    
    class Solution
    {
    public:
        void merge(std::vector<int>& nums1, int m, std::vector<int>& nums2, int n)
        {
            int p = m + n - 1;
            int p1 = m - 1;
            int p2 = n - 1;
            while (p1 >= 0 && p2 >= 0)
            {
                nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }
            while (p2 >= 0)
            {
                nums1[p--] = nums2[p2--];
            } 
        }
    };
}