#pragma once
#include <vector>

/**
 * 汇总区间:
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 
 * 示例 2:
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
namespace Leetcode228
{
    class Solution
    {
    public:
       /**
         * 双指针:
         * 指针p1指向有序子数组的第一个元素，指针p2指向有序子数组的最后一个元素的后一个
         * 遍历数组nums，把p1指向的元素暂时保存在一个列表中，
         * 如果相邻元素差值为1，就移动p2，直到遇到不相邻元素，这时把p2指向元素的前一个元素添加进列表中，就找到了一个有序区间，
         * 然后把这个有序区间添加进返回结果列表，更新p1 = p2，重复上述步骤，直到nums遍历完毕
         */
        std::vector<std::string> summaryRanges(std::vector<int>& nums) 
        {
            std::vector<std::string> ret;
            if(nums.empty())
            {
                return ret;
            }
            std::string range;
            int p1 = 0;
            int p2 = 0;
            range.append(std::to_string(nums[p1]));
            while(p2 < nums.size())
            {
                if(p2 > 0 && nums[p2] != nums[p2 - 1] + 1)
                {
                    if(p2 - p1 != 1)
                    {
                        range.append("->").append(std::to_string(nums[p2 - 1]));
                    }
                    ret.push_back(range);

                    p1 = p2;
                    range.assign("");
                    range.append(std::to_string(nums[p1]));
                }
                p2++;
            }
            if(p2 - p1 != 1)
            {
                range.append("->").append(std::to_string(nums[p2 - 1]));
            }
            ret.push_back(range);
            return ret;
        }
    };
}