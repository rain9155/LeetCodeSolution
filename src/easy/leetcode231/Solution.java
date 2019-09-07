package easy.leetcode231;

/**
 * 2的幂:
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 示例 3:
 * 输入: 218
 * 输出: false
 */
public class Solution {

    /**
     * 位运算：
     * 2的幂的二进制位除了最高位为1，其余的为0
     * 所以只要把n的最后一位1置为0，判断是否等于0即可
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
