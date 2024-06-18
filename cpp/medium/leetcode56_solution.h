#pragma once
#include <vector>

/**
 * 合并区间:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
namespace Leetcode56
{
    class Solution
    {
    public:
        /**
         * 先按首位置进行排序;
         * 1、先按首位置排序，然后区间首位置肯定是从小到大
         * 2、接着如果相邻区间可以合并，就往右找，找出最大的右边界值，然后把这个几个区间合并成一个新区间，否则更新左边界和右边界
         * 3、重复2直到把所有要合并的区间合并
         */
        std::vector<std::vector<int>> merge(std::vector<std::vector<int>>& intervals) 
        {
            std::vector<std::vector<int>> ret;
            if(intervals.size() == 0)
            {
                return ret;
            }
            std::sort(intervals.begin(), intervals.end());
            int i = 0;
            while (i < intervals.size())
            {
                std::vector<int> range = intervals[i];
                int left = range[0];
                int right = range[1];
                while (i < intervals.size() - 1 && right >= intervals[i + 1][0])//找出右边界
                {
                    right = std::max(right, intervals[i + 1][1]);
                    i++;
                }
                ret.push_back({left, right});
                i++;
            }
            return ret;
        }
    };
}