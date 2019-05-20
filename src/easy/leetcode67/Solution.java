package easy.leetcode67;

import java.util.Arrays;

/**
 * 二进制求和:
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class Solution {

    /**
     * O(n)
     * 先对齐，再逐个取出求和
     */
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        String temp = "0";
        if(aLen < bLen){
            for (int i = 1; i < bLen - aLen; i++){
                temp += "0";
            }
            a = temp + a;
        }else if (aLen > bLen){
            for (int i = 1; i < aLen - bLen; i++){
                temp += "0";
            }
            b = temp + b;
        }
        int i = maxLen - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        while (i >= 0){
            int num1 = a.charAt(i) - 48;
            int num2 = b.charAt(i) - 48;
            int sum = num1 + num2 + carry;
            int thisRet = sum < 2 ? sum : sum - 2;
            builder.insert(0, thisRet);
            carry = sum < 2 ? 0 : 1;
            i--;
        }
        if(carry > 0) builder.insert(0, carry);
        return builder.toString();
    }

}
