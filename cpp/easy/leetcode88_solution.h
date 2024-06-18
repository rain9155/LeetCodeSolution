#pragma once
#include <vector>

/**
 * 合并两个有序数组:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
namespace Leetcode88
{
    
    class Solution
    {
    public:
        /**
         * 双指针：
         * 把p指向扩容后的num1的最后面，
         * 从两个有序数组的后面开始遍历比较，如果哪个数大，就把哪个数放到num1中的后面，
         * 然后p减一，直到所有数排完。
         */
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