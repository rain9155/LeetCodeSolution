package medium.leetcode400;

/**
 * 第N个数字:
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 示例 1:
 * 输入:
 * 3
 * 输出:
 * 3
 * 示例 2:
 * 输入:
 * 11
 * 输出:
 * 0
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class Solution {

    public int findNthDigit(int n) {
        if(n < 10){
            return n;
        }
        int bit = 1;
        int bitCount = getCountByBit(bit);
        //找出这个n在哪个bit区间
        while (n > bitCount){
            n -= bitCount;
            bit++;
            bitCount = getCountByBit(bit);
        }
        //获得这个bit区间的第一个数
        int base = getBaseByBit(bit);
        //找出n在这个区间偏移了多少个数字
        int offset = (n - 1)/ bit;
        //base加offset就是n在第几个数
        int num = base + offset;
        //找出n在第几个数的第几位
        int index = n % bit;
        char[] chars =  String.valueOf(num).toCharArray();
        //在最后一位
        if(index == 0) return chars[bit - 1] - '0';
        return chars[index - 1] - '0';
    }

    /**
     * 返回bit位的所有数字的所有位加起来的数目
     * 如bit = 2，返回[10, 99]的所有数字的所有位加起来的数目，为2 * 10 * 9 = 180位
     */
    private int getCountByBit(int bit){
        int ret = 1;
        for(int i = 0; i < bit - 1; i++){
            ret *= 10;
        }
        return ret * 9 * bit;
    }

    /**
     * 返回bit位数字的第一个数字
     * 如bit = 2，返回10， bit = 3，返回100
     */
    private int getBaseByBit(int bit){
        if(bit < 2){
            return 0;
        }
        return (int) Math.pow(10, bit - 1);
    }

}
