#pragma once
#include <vector>

/**
 * 数组中的第K个最大元素:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 提示：
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
namespace Leetcode215
{
    class Solution
    {
    public:
        /**
         * 最大堆：O(nlogn)
         * 根据数组创建一个最大堆，对最大堆做 k-1 次删除操作，最后堆顶的元素就是数组nums的第k最大元素
         */
        int findKthLargest(std::vector<int>& nums, int k)
        {
            if(nums.empty())
            {
                return -1;
            }
            int heapSize = nums.size();
            buildMaxHeap(nums, heapSize);
            for(int i = nums.size() - 1; i >= (nums.size() - (k - 1)); i--)
            {
                std::swap(nums[0], nums[i]);
                heapSize--;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

    private:
        /**
         * 最大堆调整：
         * 把root节点对应的二叉树调整为最大堆
         */
        void maxHeapify(std::vector<int>& nums, int root, int heapSize)
        {
            int left = 2 * root + 1;
            int right = 2 * root + 2;
            int maxium = root;
            if(left < heapSize && nums[left] > nums[maxium])
            {
                maxium = left;
            }
            if(right < heapSize && nums[right] > nums[maxium])
            {
                maxium = right;
            }
            if(maxium != root)
            {
                std::swap(nums[root], nums[maxium]);
                maxHeapify(nums, maxium, heapSize);
            }
        }

        /**
         * 最大堆构建：
         * 从后往前把所有非叶子节点进行最大堆调整
         */
        void buildMaxHeap(std::vector<int>& nums, int heapSize)
        {
            for(int i = heapSize / 2; i >= 0; i--)
            {
                maxHeapify(nums, i, heapSize);
            }
        }
    };
}