#pragma once
#include <string>

using namespace std;

/**
 * 二进制求和:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
namespace Leetcode67
{
    class Solution 
    {
    public:
        /**
         * 模拟：O(n)
         * 长度较短的二进制字符串先用0对齐，再逐个取出求和
         */
        string addBinary(string a, string b)
        {
            int aLen = a.size();
            int bLen = b.size();
            int maxLen = max(aLen, bLen);

            int diffLen = abs(aLen - bLen);
            if(diffLen > 0)
            {
                string temp;
                for(int i = 0; i < diffLen; i++)
                {
                    temp.append("0");
                }
                if(aLen < bLen)
                {
                    temp.append(a);
                    a = temp;
                }
                else if(bLen < aLen)
                {
                    temp.append(b);
                    b = temp;
                }
            }

            string ret;
            int carry = 0;
            int i = maxLen - 1;
            while (i >= 0)
            {
                int num1 = a[i] - '0';
                int num2 = b[i] - '0';
                int sum = num1 + num2 + carry;
                ret.append(to_string(sum % 2));
                carry = sum / 2;
                i--;
            }
            if(carry > 0)
            {
                ret.append(to_string(carry));
            }
            reverse(ret.begin(), ret.end());

            return ret;
        }
    };
}