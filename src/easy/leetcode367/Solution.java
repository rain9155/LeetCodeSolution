package easy.leetcode367;

/**
 * 有效的完全平方数:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 * 示例 2：
 * 输入：14
 * 输出：False
 */
public class Solution {

    /**
     * 方法1：二分查找
     * 在[1, num]的范围内寻找是否有某个数的平方数等于num
     */
    public boolean isPerfectSquare(int num) {
        if(num <= 0) return false;
        int start = 1;
        int end = (int)Math.round(Math.sqrt(num));
        while(start <= end){
            int mid = start + (end - start) / 2;
            int peek = mid * mid;
            if(peek == num){
                return true;
            }else if(peek < num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }


    /**
     * 方法2：数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
     */
    public boolean isPerfectSquare2(int num) {
        if(num <= 0) return false;
        int i = 1;
        while (num > 0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /**
     * 参考资料：https://www.matongxue.com/madocs/205.html
     * 方法3：牛顿迭代法，可以快速求出num的平方根，用这个平方根和自己相乘再判断是否等于num即可
     * 假设要求x^2 = a,转化为x^2 - a = 0，由牛顿迭代法得：x2 = x1 - (f(x1) / f`(x1)) = x1 - ((x1^2 - a) / 2x1) = (x1 + a/ x1)/ 2
     * 其中x2就是要求得平方根，x1随便取一个数，a就是num，因为要求x^2 = num
     */
    public boolean isPerfectSquare3(int num) {
        if(num <= 0) return false;
        long x2 = num;
        while (x2 * x2 > num){
            x2 = (x2 + num / x2) / 2;
        }
        int squrt = (int)x2;
        return num == squrt * squrt;
    }


}
