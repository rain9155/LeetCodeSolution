#pragma once
#include <vector>

/**
 * 求众数:
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
namespace Leetcode169
{
    class Solution
    {
    public:
        /**
         * Boyer-Moore（投票算法): O（n）
         * 1、首先维护一个计数器count，初始值等于0，然后定义一个投票候选人num
         * 2、从第一个数开始，遇到值等于num的数，计数器就加1；遇到值不等于num的数，计数器就减1
         * 3、当计数器减到0时，就更换候选人为当前遍历的数，然后重新计数
         * 4、最后返回投票候选人num，就是在数组中出现最多的元素
         */
        int majorityElement(std::vector<int>& nums)
        {
            int count = 0;
            int num = 0;
            for(int i = 0; i < nums.size(); i++)
            {
                if(count == 0)
                {
                    num = nums[i];
                }
                if(num == nums[i])
                {
                    count++;
                }
                else
                {
                    count--;
                }
            }
            return num;
        }
    };
}