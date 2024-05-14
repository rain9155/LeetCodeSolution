#pragma once
#include <string>
#include <set>

/**
 * 无重复字符的最长子串：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
namespace Leetcode3
{
    class Solution
    {
    public:
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