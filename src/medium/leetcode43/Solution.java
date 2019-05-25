package medium.leetcode43;

import java.util.Arrays;

/**
 * 字符串相乘:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution {

    /**
     * O（n^2）：
     * 根据num1和num2相乘得出规律：
     * num1：  123   => j = 0,..
     * num2：x 456   => i = 0,..
     *       -----
     *         738
     *        615
     *       492
     *      ------
     *       56088 => result[num1.len + num2.len]
     * num1的每个数与num2的每个数相乘，所得到的结果在result的位置是（i + j + 1），
     * 所以弄两个for循环，循环遍历i、j，把每步相乘的结果累加在result相应的位置，
     * 然后再弄一个for循环对result中需要进位的数字进行进位。
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;//result的长度
        if(len1 == 0 || len2 == 0) return "";
        if(len1 == 1 && num1.charAt(0) == '0') return "0";
        if(len2 == 1 && num2.charAt(0) == '0') return "0";
        int[] result = new int[len1 + len2];
        for(int i = len2 -1 ; i >= 0; i--){
            int n2 = num2.charAt(i) - 48;
            for(int j = len1 - 1; j >= 0; j--){
                int n1 = num1.charAt(j) - 48;
                //int index = len - (len2 - i - 1) - (len1 - j - 1) - 1;
                result[i + j + 1] += n1 * n2;//累加当前乘积
            }
            for(int t = result.length - 1; t >= 0; t--){
                if(result[t] >= 10){
                    result[t - 1] += result[t] / 10;//进位给下一位
                    result[t] = result[t] % 10;//进位后当前位留下的位数
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(i == 0 && result[i] == 0)
                continue;
            builder.append(result[i]);
        }
        return builder.toString();
    }

}
