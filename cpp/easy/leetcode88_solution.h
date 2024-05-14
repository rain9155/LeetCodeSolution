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
        void merge(std::vector<int>& nums1, int m, std::vector<int>& nums2, int n);
    };
}