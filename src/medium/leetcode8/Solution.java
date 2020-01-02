package medium.leetcode8;

/**
 * 字符串转换整数 (atoi)：
 * 将字符串转换成整数。
 *
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class Solution {

    /**
     * 蛮力法：
     */
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.isEmpty()) return 0;
        int ret = 0, i;
        for(i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(i == 0 && (ch == '-' || ch == '+'))
               continue;
            if(ch < '0' || ch > '9')
                break;
        }
        str = str.substring(0, i);
        try {
            if(str.length() == 0) return 0;
            char ch = str.charAt(0);
            if(str.length() == 1 && ((ch == '-' || ch == '+'))) return 0;
            ret = Integer.valueOf(str);
        }catch (Exception e){
            return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return ret;
    }

}
