#pragma once
#include <vector>
#include <unordered_map>
#include <array>

/**
 * 字母异位词分组:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序
 */
namespace Leetcode49
{
    class Solution
    {
    public:
        /**
         * 按计数分类：O(nk)
         * 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词
         * 维护一个映射 map : {String -> List}，其中每个键是一个计数排序的字符串
         * 最后输出map中每个键对应的List集合就是结果
         */
        std::vector<std::vector<std::string>> groupAnagrams(std::vector<std::string>& strs)
        {
            std::vector<std::vector<std::string>> ret;
            if(strs.empty())
            {
                return ret;
            }
            std::unordered_map<std::string, std::vector<std::string>> map;
            std::array<int, 26> array;
            std::string key;
            for(std::string str : strs)
            {
                array.fill(0);
                //对每个字符出现的次数计数
                for(char c : str)
                {
                    array[c - 'a']++;
                }
                key.assign("");
                //构造map的键，即一个用 ＃ 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目
                for(int count : array)
                {
                    key.append("#").append(std::to_string(count));
                }
                map[key].push_back(str);
            }
            for(auto pair : map)
            {
                ret.push_back(pair.second);
            }
            return ret;
        }
    };
}