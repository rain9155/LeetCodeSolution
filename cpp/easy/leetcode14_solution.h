#pragma once
#include <string>
#include <vector>

/**
 * 查找字符串数组中的最长公共前缀:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
namespace Leetcode14
{
    class Solution
    {
    public:
        /**
         * O(nm),n为字符串数组的长度，m为每个字符串的长度
         * 水平扫描法：
         * 1、如果strs不为空，把strs的第一个字符串作为默认前缀prefix
         * 2、每个取strs中的后一个字符串与prefix比较，如果有共同的前缀，则更新prefix为最新的共同前缀，如果没有就返回“”，就表示字符串数组中没有最长公共前缀
         * 3、重复第2步，直到遍历完字符数组
         */
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