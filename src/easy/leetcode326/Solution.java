package easy.leetcode326;

/**
 * 3的幂：
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * 输入: 0
 * 输出: false
 * 示例 3:
 * 输入: 9
 * 输出: true
 * 示例 4:
 * 输入: 45
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class Solution {


    /**
     * 递归：
     * 把n一直除以3，直到n等于1，就说明它是3的幂次方，否则不是
     */
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    /**
     * 数学：
     * n=3^i => i=log3(n) => i = log?(n) / log?(3)
     * 如果要n是3的幂，则i一定为整数，所以通过计算log?(3) / log?(n)，判断结果是否是整数即可
     */
    public boolean isPowerOfThree2(int n) {
        double num = Math.log10(n) / Math.log10(3);
        return (num - (int)num) < Double.MIN_VALUE;
    }

}
