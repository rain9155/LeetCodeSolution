package medium.leetcode201;

/**
 * 数字范围按位与:
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 */
public class Solution {

    /**
     * O(n)
     * 蛮力法：超时
     * 逐位与
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m < 0 || n < 0) return 0;
        int ret = Integer.MAX_VALUE;
        while (m <= n){
            ret &= m;
            m++;
        }
        return ret;
    }

    /**
     * 求公共前缀：
     * 数字范围按位与的结果就是m 与 n的公共前缀，不足32位补零
     * 当n 与 n - 1相与时，总会把最后一个1去掉，例如n = 00111， m = 00101, 当n 与 n - 1不断相与时，最终n = 00100， n < m, 而此时n就是结果
     */
    public int rangeBitwiseAnd2(int m, int n) {
        if(m < 0 || n < 0) return 0;
        while (n > m){
            n &= n - 1;
        }
        return n;
    }

}
