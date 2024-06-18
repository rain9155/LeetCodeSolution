#pragma once
#include <cstdint>

/**
 * 颠倒二进制位:
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 
 * 示例 2：
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *       因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。
 *  
 * 提示：
 * 输入是一个长度为 32 的二进制字符串
 *  
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
namespace Leetcode190
{
    class Solution
    {
    public:
        /**
         * 位运算：
         * 依此取出n的最低位，放到ret的最低位，每次取出n的最低位之前，先把ret左移一位，让ret的最低位留出来
         */
        uint32_t reverseBits(uint32_t n)
        {
            uint32_t ret = 0;
            for(int i = 0; i < 32; i++)
            {
                ret <<= 1;
                ret |= n & 1;
                n >>= 1;
            }
            return ret;
        }
    };
}