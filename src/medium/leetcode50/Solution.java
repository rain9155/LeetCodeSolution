package medium.leetcode50;

/**
 * Pow(x, n):
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class Solution {

    /**
     * O(n)
     * 蛮力法
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return x;
        double ret = 1.0;
        x = n > 0 ? x : 1 / x;
        n = Math.abs(n);
        for(int i = 0; i < n; i++){
            ret *= x;
        }
        return ret;
    }

    /**
     * O(logn)
     * 快速幂算法（递归）:
     * 2^10 = (2^5)^2
     * 2^5 = (2^2)^2 * 2
     * 2^2 = 2 * 2
     * 就这样不断的二分下去，直到n等于1，直接返回x，返回到递归的上一层，如果n是偶数，就把返回结果平方，如果n是奇数，就把返回结果平方后再累乘x
     */
    public double myPow2(double x, int n) {
        if(n == 0) return 1;
        x = n > 0 ? x : 1 / x;
        n = Math.abs(n);
        return pow(x, n);
    }

    private double pow(double x, int n){
        if(n == 1) return x;
        double half = pow(x, n / 2);
        half *= half;
        if(n % 2 != 0) half *= x;
        return half;
    }

    /**
     * O(logn)
     * 快速幂算法（迭代）:
     * 和上面面的原理一样, 如果n是奇数才累乘，否则平方
     */
    public double myPow3(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return x;
        x = n > 0 ? x : 1 / x;
        n = Math.abs(n);
        double ret = 1;
        double temp = x;
        while (n != 0){
            temp *= temp;
            if(n % 2 != 0) ret *= temp;
            n /= 2;
        }
        return ret;
    }

    /**
     * O(logn)
     * 从左至右的二进制幂算法:
     * 把n转化位为二进制位串，从左到右扫描二进制位串
     * 累乘器初始化为x，我们从左到右扫描位串，除去第一位，如果当前二进制是0，把累乘器进行平方，如果当前二进制是1，把累乘器进行平方再乘x
     */
    public double myPow4(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return x;
        x = n > 0 ? x : 1 / x;
        n = Math.abs(n);
        String bitStr = Integer.toBinaryString(n);
        double ret = x * 1.0;
        for(int i = 1; i < bitStr.length(); i++){
            int bit = bitStr.charAt(i) - 48;
            ret *= ret;
            if(bit == 1) ret *= x;
        }
        return ret;
    }

    /**
     * O(logn)
     * 快速幂算法（迭代），又名从右到左的二进制幂算法:
     *  把n转化位为二进制位串，从右到左扫描二进制位串
     *  初始累乘器为1，如果当前二进制是0，忽略，如果当前二进制是1，把累乘器乘以x^(2^i)，i为当前二进制串的位权
     */
    public double myPow5(double x, int n) {
        if(n == 0) return 1;
        if(x == 1) return x;
        x = n > 0 ? x : 1 / x;
        long absN = Math.abs((long) n);
        double ret = 1;
        double temp = x;
        while (absN > 0){
            if((absN & 1) == 1) ret *= temp;
            temp *= temp;//计算x^(2^i)
            absN >>= 1;
        }
        return ret;
    }



}
