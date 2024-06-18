#pragma once
#include <vector>

/**
 * 删除排序数组中的重复项:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
namespace Leetcode26
{
    class Solution
    {
    public:
        /**
         * O（n）
         * 双指针（快慢指针）:
         * 1、放置两个指针i， j， i指向第一个元素，j指向第二个元素
         * 2、当j指向的元素与i指向的元素相等时，j后移，直到出现j指向的元素不等于i指向的元素，i后移一位，然后把j指向的元素赋值给i指向的元素
         * 3、i 与 j永远相隔着n个相等的元素，
         */
        int removeDuplicates(std::vector<int>& nums)
        {
            if(nums.size() == 0)
            {
                return 0;
            }

            int slow = 0;
            for(int fast = 1; fast < nums.size(); fast++)
            {
                if(nums[slow] != nums[fast])
                {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            
            return slow + 1;
        }
    };
}