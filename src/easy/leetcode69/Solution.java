package easy.leetcode69;

/**
 * x 的平方根:
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class Solution {

    /**
     * 二分法：
     * 因为对于一个非负数x，它的平方根的范围是[0, (x / 2 +_1)]， 所以只要在这个范围内使用二分查找就行
     */
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        long i = 0;
        long j = x / 2 + 1;///对于一个非负数x，它的平方根不会大于（x/2+1）
        while (i <= j){
            long mid = (i + j) / 2;
            long temp = mid * mid;//这里可能会溢出
            if(temp == x) return (int) mid;//等于直接返回
            else if(temp < x) i = mid + 1;//比x还小，i右移
            else j = mid - 1;//比x还大，j左移
        }
        //能跳出循环说明x的平方根不是一个整数，i > j, 这里返回j， j的平方是最接近x并不大于x的数
        return (int) j;
    }

    /**
     * 牛顿迭代法：
     * 把求x的平方根转为：x = t^2 -> t^2 - x = 0 -> f(t) = t^2 - x
     * 所以问题的求解就变为求当f(t) = 0， t的值，即f(t)与t轴相交的t坐标
     * (1) 我们在f(t)的图像上任意取一个初始点（t,f(t)），作它的切线
     * (2) 切线与X轴交点横坐标为t0，接下来我们又作（t0， f(t0))的切线,
     * 有没有发现，我们作的切线再逐渐向左偏，切线与t轴的交点也慢慢接近图像与t轴的交点，并且切线与t轴的交点也慢慢接近切线与图像的切点
     * (3) 重复（2），一直重复以上作切线过程，最后它们会无限逼近，当切线与t轴的交点与切线与图像的切点重合，此时的t0就是要求的平方根
     */
    public int mySqrt2(int x) {
        if(x <= 0) return 0;
        //切线与t轴的交点
        double last = 0;
        //取（x， f(x)） 为初始点，做切线，切点坐标
        double x0 = x;
        //判断x0收敛于last
        while (Math.abs(x0 - last) >= 1){
            last = x0;
            x0 = x0 / 2 + x / (2 * x0);
        }
        //当x0收敛于last会跳出循环，此时x0就是要求的平方根
        return (int) x0;
    }

}
