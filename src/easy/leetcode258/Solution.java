package easy.leetcode258;

/**
 * 各位相加:
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class Solution {

    /**
     * 递归：
     */
    public int addDigits(int num) {
        if(num <= 9) return num;
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    /**
     * 找规律：
     * 假设num是两位数，有：num = xy = x * 10 + y = x * 9 + x + y，得x + y = num % 9
     * 所以num各位相加得下一个数是对num模9
     */
    public int addDigits2(int num) {
        if(num <= 9){
            return num;
        }
        int temp = num % 9;
       return temp == 0 ? 9 : addDigits2(temp);
    }

}
