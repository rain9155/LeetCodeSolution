package easy.leetcode66;

/**
 * 加一:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位，数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Solution {

    /**
     * 从digits最后一位开始加一，判断，如果 < 10 则表示没有产生进位直接返回，否则产生进位，把进位加到下一个数子
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        for(int i = len - 1; i >= 0; i--){
            int thisSum = digits[i] + carry;
            if(i == len - 1) thisSum += 1;
            if(thisSum < 10){
                digits[i] = thisSum;
                carry = 0;
                break;
            }else {
               carry = thisSum - 9;
               thisSum = thisSum % 10;
               digits[i] = thisSum;
            }
        }
        if(carry > 0){
            int[] temp = digits;
            digits = new int[len + 1];
            digits[0] = carry;
            int i = 1;
            for(int num : temp){
                digits[i] = num;
                i++;
            }
        }
        return digits;
    }

}
