package medium.leetcode166;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数：
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class Solution {

    /**
     * 模拟长除法:
     * 核心思想是当余数出现循环的时候，对应的商也会循环,
     * 所以需要用一个哈希表记录余数出现在小数部分的位置，当你发现已经出现的余数，就可以将重复出现的小数部分用括号括起来。
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        StringBuilder builder = new StringBuilder();
        //当两个数异号，相除结果是负数
        if(numerator < 0 ^ denominator < 0) builder.append("-");
        //转成long，防止溢出
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor  = Math.abs(Long.valueOf(denominator));
        builder.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;//取余数
        if (remainder == 0) return builder.toString();//如果余数为零，表示相除结果不是小数，如 2 / 1 = 2
        builder.append(".");
        Map<Long, Integer> map = new HashMap<>();//用来记录余数在小数中出现的位置
        while (remainder != 0){
            if(map.containsKey(remainder)){//如果余数在这个位置出现过
                builder.insert(map.get(remainder), "(")
                        .append(")");
                break;
            }
            map.put(remainder, builder.length());
            //模拟长除法，记录出现的余数
            remainder *= 10;
            builder.append(String.valueOf(remainder / divisor));
            remainder = remainder % divisor;
        }
        return builder.toString();
    }

}
