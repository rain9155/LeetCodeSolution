#pragma once
#include <string>
#include <vector>

/**
 * 查找字符串数组中的最长公共前缀:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
namespace Leetcode14
{
    class Solution
    {
    public:
        std::string longestCommonPrefix(std::vector<std::string>& strs)
        {
            if(strs.empty() || strs[0].empty())
            {
                return "";
            }
            std::string prefix = strs[0];
            for(int i = 1; i < strs.size(); i++)
            {
                while(strs[i].find_first_of(prefix) != 0)
                {
                    prefix = prefix.substr(0, prefix.size() - 1);
                    if(prefix.empty())
                    {
                        return "";
                    }
                }
            }
            return prefix;
        }
    };
}