#pragma once
#include <string>

/**
 * 有效的字母异位词:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
namespace Leetcode242
{
    class Solution
    {
    public:
        /**
         * 哈希表：
         * 因为都是小写字母，所以范围为'a'到'z',只有26个字母
         * 我们可以使用一个大小为26的数组来保存s的每一个字母到索引的映射
         * 然后再去遍历t，遇到相同的字母到索引的映射，就把该数组的数值减一
         * 最后，如果t是s的字母异位词，那么数组的数值一定都是0
         */
        bool isAnagram(std::string s, std::string t) 
        {
            if(s.size() != t.size())
            {
                return false;
            }
            int nums[26] = {0};
            for(char c : s)
            {
                int num = c - 97;
                nums[num]++;
            }
            for(char c : t)
            {
                int num = c - 97;
                if(nums[num] == 0)
                {
                    return false;
                }
                nums[num]--;
            }
            for(int num : nums)
            {
                if(num > 0)
                {
                    return false;
                }
            }
            return true;
        }
    };
}