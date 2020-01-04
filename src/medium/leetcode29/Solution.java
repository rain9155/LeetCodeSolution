package medium.leetcode29;


/**
 * 两数相除:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 */
public class Solution {

    /**
     * 暴力法：
     * 被除数一直减除数，知道被除数为零
     */
    public int divide(int dividend, int divisor) {
        int ret = 0;
        if(divisor == 0) return ret;
        //处理溢出，因为abs(Integer.MIN_VALUE) > Integer.MAX_VALUE
        if(dividend <= Integer.MIN_VALUE && divisor == -1 && divisor == -1) return Integer.MAX_VALUE;
        //需要进行转换，不然会溢出无法取绝对值
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        while (absDividend >= 0){
            absDividend -= absDivisor;
            ret++;
        }
        --ret;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ret = -ret;
        return ret;
    }

    /**
     * 位移法：
     * 找出除数最接近被除数的那个数close， close % divisor == 0，而商就是close / divisor
     */
    public int divide2(int dividend, int divisor) {
        int ret = 0;
        if(divisor == 0) return ret;
        //处理溢出，因为abs(Integer.MIN_VALUE) > Integer.MAX_VALUE
        if(dividend <= Integer.MIN_VALUE && divisor == -1 && divisor == -1) return Integer.MAX_VALUE;
        //需要进行转换，不然会溢出无法取绝对值
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        boolean navigate = (dividend ^ divisor) < 0;//判断是否异号
        while (absDividend >= absDivisor){
            int shift = 1;//移位的位数
            while (absDividend >= (absDivisor << shift)) shift++;//不断左移除数，增大除数，使除数刚好超过被除数
            long closed = absDivisor << (shift - 1);//找出除数最接近被除数的那个数
            absDividend -= closed;//被除数减去closed，从余数继续找最接近它的除数倍数
            ret += 1 << (shift - 1);//结果加上除数的倍数
        }
        return navigate ? -ret : ret;
    }

}
