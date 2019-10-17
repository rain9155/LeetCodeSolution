package medium.leetcode365;

/**
 * 水壶问题:
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class Solution {

    /**
     * 数学：
     * 如果x和y可取z升水，那么一定有a * x + b * y = z
     * 所以我们要求是否存在整数解a 和 b 使得ax + by = z
     * 根据裴蜀定理：对任何整数a、b和它们的最大公约数d，对于未知数x和y，当ax + by = z有整数解时，当且仅当z是d的倍数。
     * 所以问题转化为，求z是否是x和y的最大公约数的倍数，如果是，那么ax + by = z有解，返回true
     */
    public boolean canMeasureWater(int x, int y, int z) {
        //要取的水z大于两个水壶x和y的容量，所以x和y不可能取到z升水
        if(x + y < z) return false;
        if(z == 0) return true;
        //判断要取的水z是否是两个水壶x和y的容量的最大公约数的倍数
        return z % gcd(x, y) == 0;
    }

    /***
     * 求x和y的最大公约数
     */
    private int gcd(int x, int y){
        int min = Math.min(x, y);
        while (min > 0){
            if(x % min == 0 && y % min == 0) return min;
            min--;
        }
        return 1;
    }

}
