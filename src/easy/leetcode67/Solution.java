package easy.leetcode67;

import java.util.Arrays;

/**
 * 二进制求和:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
public class Solution {

    /**
     * 模拟：O(n)
     * 长度较短的二进制字符串先用0对齐，再逐个取出求和
     */
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        String temp = "";
        if(aLen < bLen){
            for (int i = 0; i < bLen - aLen; i++){
                temp += "0";
            }
            a = temp + a;
        }else if (aLen > bLen){
            for (int i = 0; i < aLen - bLen; i++){
                temp += "0";
            }
            b = temp + b;
        }
        int i = maxLen - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (i >= 0){
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';
            int sum = num1 + num2 + carry;
            builder.append(sum % 2);
            carry = sum / 2;
            i--;
        }
        if(carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

}
