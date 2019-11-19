package easy.leetcode415;

/**
 * 字符串相加:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        while(p1 >= 0 || p2 >= 0 || carry > 0){
            if(p1 >= 0) carry += num1.charAt(p1--) - '0';
            if(p2 >= 0) carry += num2.charAt(p2--) - '0';
            ret.append(carry % 10);
            carry /= 10;
        }
        return ret.reverse().toString();
    }

}
