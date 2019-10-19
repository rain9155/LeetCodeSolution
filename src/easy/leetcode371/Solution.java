package easy.leetcode371;

/**
 * 两整数之和:
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class Solution {

    /**
     * 位运算;
     * 1、异或运算就是不进位的相加，与运算可以把两个二进制位都是1的位取出来，而二进制的相加，只有两个位都是1时才会进位
     * 2、所以我们可以用异或运算把两个二进制位没有进位的运算结果算出来，然后用与运算把需要进位的位取出来再左移一位，就得到需要相加的进位
     * 3、进位与异或结果向加后再判断有没有进位，如果有，重复第二步
     * 例如 2 + 3 = 5
     * 2        0010
     * 3        0011
     * 5        0101
     * 第一步：  xor = 2^3 = 0001,  而carry = (2 & 3）<< 1 = 0100 不等于0，有进位，所以进行第二步
     * 第二步把进位和xor相加： xor = xor ^ carry = 0101, 而carry = (preSum & carry) << 1 == 0000 等于0，没有进位，运算结束
     */
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = (a & b) << 1;
        while(carry != 0){
            int preSum = xor;
            xor = xor ^ carry;
            carry = (preSum & carry) << 1;
        }
        return xor;
    }

}
