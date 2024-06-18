#pragma once
#include <string>
#include <map>

/**
 * 同构字符串:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
namespace Leetcode205
{
    class Solution
    {
    public:
        /**
         * 哈希表:
         * 用一个map建立两个字符串在每个字符的映射关系，在遍历s时，取出字符c，判断c在map中的映射是否等于t相应位置的字符
         */
        bool isIsomorphic(std::string s, std::string t)
        {
            if(s.size() != t.size())
            {
                return false;
            }
            std::map<char, char> map;
            for(int i = 0; i < s.size(); i++)
            {
                if(!isContainsKey(map, s[i]))
                {
                    if(isContainsValue(map, t[i]))
                    {
                        return false;
                    }
                    map.insert(std::make_pair(s[i], t[i]));
                }
                else
                {
                    if(map[s[i]] != t[i])
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        bool isContainsKey(std::map<char, char>& map, char c)
        {
            return map.find(c) != map.end();
        }

        bool isContainsValue(std::map<char, char>& map, char c)
        {
            for(auto it = map.begin(); it != map.end(); it++)
            {
                if(it->second == c)
                {
                    return true;
                }
            }
            return false;
        }
    };
}