#pragma once
#include <queue>
#include <vector>

using namespace std;

/**
 * 查找和最小的K对数字:
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 */
namespace Leetcode373
{
    class Solution
    {
    public:
        /**
         * 最小堆（优化版）：O(klogk)
         * 记数对[nums1[i], nums2[j]]对应的下标对为[i, j], 先把数对[nums1[i], nums2[0]]的下标对[i, 0]放入最小堆中
         * 这时堆顶的下标对为[0, 0]，其对应的数对是所有数对中和最小的, 弹出堆顶的下标对，把下标对对应的数对放入答案，再尝试把[i, j + 1]下标对放入最小堆中, 直到弹出k次堆顶元素
         */
        vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k)
        {
            vector<vector<int>> ret;
            if(nums1.size() == 0 || nums2.size() == 0)
            {
                return ret;
            }
            auto comparator = [&nums1, &nums2](pair<int, int>& indexs1, pair<int, int>& indexs2)
            {
                int sum1 = nums1[indexs1.first] + nums2[indexs1.second];
                int sum2 = nums1[indexs2.first] + nums2[indexs2.second];
                return sum1 > sum2;
            };
            priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comparator)> minHeap(comparator);
            int len1 = nums1.size();
            int len2 = nums2.size();
            for(int i = 0; i < min(len1, k); i++)
            {
                 minHeap.emplace(make_pair(i, 0));
            }
            while (k > 0 && !minHeap.empty())
            {
                auto indexs = minHeap.top();
                minHeap.pop();
                ret.push_back({nums1[indexs.first], nums2[indexs.second]});
                if(indexs.second + 1 < len2) 
                {
                    minHeap.emplace(make_pair(indexs.first, indexs.second + 1));
                }
                k--;
            }
            return ret;
        }
    };
}