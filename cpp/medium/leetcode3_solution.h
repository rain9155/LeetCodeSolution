#pragma once
#include <string>
#include <set>

/**
 * 无重复字符的最长子串：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
namespace Leetcode3
{
    class Solution
    {
    public:
        /**
         * Set + 滑动窗口：O(2n) = O(n)
         * 1、不断移动[i,j）（移动i或j），移动过程中记录最大 子字符串 的长度，在[i,j)范围内的字符串永远不会重复
         * 2、第j个指向的元素与[i, j - 1]内的元素没有重复时，把它添加进集合[i, j]，并移动j
         * 3、第j个指向的元素与[i, j - 1]内的元素重复时，j停止，i移动，直到[i, j - 1]内的重复元素被移除，此时i停止，j才继续移动
         */
        int lengthOfLongestSubstring(std::string s)
        {
            int count = 0;
            int i = 0; 
            int j = 0;
            std::set<char> set;
            while(i < s.length() && j < s.length())
            {
                char c = s[j];
                if(set.find(c) == set.end())
                {
                    set.insert(c);
                    count = std::max(count, (j - i + 1));
                    j++;
                }
                else
                {
                    set.erase(s[i]);
                    i++;
                }
            }
            return count;
        }
    };
}