package medium.leetcode343;

/**
 * 整数拆分:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/
     * 贪心算法：
     * 特殊处理2、3、4，当n > 4时，尽可能分解出3，这样就能使得乘积最大
     */
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        if(n == 4){
            return 4;
        }
        int ret = 1;
        while(n > 4){
            ret *= 3;
            n -= 3;
        }
        ret *= n;
        return ret;
    }

}
