#pragma once
#include <string>
#include <stack>
#include <unordered_map>

/**
 * 有效的括号:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合
 * 2、左括号必须以正确的顺序闭合
 * 3、注意空字符串可被认为是有效字符串
 */
namespace Leetcode20
{
    class Solution 
    {
    public: 
        /**
         * 栈 + 哈希表：O(n)
         * 使用哈希表提前建立左右括号的映射，key为左括号，value为右括号
         * 遍历字符串，如果哈希表的key包含当前遍历的字符，说明为左括号，入栈
         * 否则说明为右括号，这时取出栈顶的左括号为key，从哈希表获取对应右括号看是否和当前遍历的字符匹配
         * 若不匹配返回false，若匹配成功则将栈顶元素弹出，最后如果整个栈为空则字符串有效
         */
        bool isValid(std::string s) 
        {
            std::unordered_map<char, char> map = {
                {'(', ')'},
                {'{', '}'},
                {'[', ']'}
            };   
            std::stack<char> stack;
            for(char c : s)
            {
               if(map.find(c) != map.end())
               {
                    stack.push(c);
               }
               else
               {
                    if(stack.empty() || map[stack.top()] != c)
                    {
                        return false;
                    }
                    stack.pop();
               }
            }
            return stack.empty();
        }
    };
}