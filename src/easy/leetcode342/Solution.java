package easy.leetcode342;

/**
 * 4的幂:
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 * 输入: 16
 * 输出: true
 * 示例 2:
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class Solution {

    /**
     * 位运算：
     * 1、 一个数如果它不是2的幂，那么它一定不是4的幂，则num & (num - 1) != 0，return false
     * 2、一个数如果它是2的幂，那么它可能是4的幂
     * 这时找规律：
     * 我们发现2的幂的1的出现位置在二进制位的偶数位，而4的幂的1的出现位置总是在二进制位的奇数位
     * 例如16的二进制位为10000，所以在满足2的条件下，判断这个数的1出现的位置是否在奇数位，如果在，这个数就是4的幂，否则不是
     * 所以只要用一个mask，这个mask为0x55555555，它的特点是，1都出现在奇数位，把这个mask与num相与，还是等于num的话，那么num就是4的幂
     * 例如16的二进制位为10000，mask的二进制为...10101, 16 & mask = 10000,这样16奇数位取了出来
     */
    public boolean isPowerOfFour(int num) {
        if(num <= 0 || (num & (num - 1)) != 0){
            return false;
        }
        int mask = 0x55555555;
        return (num & mask) == num;
    }

    /**
     * 数学规律：
     * 如果一个数是4的幂次方，那么：
     * 1、它是2的幂次方
     * 2、减去1之后它是3的倍数
     */
    public boolean isPowerOfFour2(int num) {
        if(num <= 0){
            return false;
        }
        return (num & num - 1) == 0 && (num - 1) % 3 == 0;
    }

}
