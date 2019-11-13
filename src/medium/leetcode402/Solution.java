package medium.leetcode402;

/**
 * 移掉K位数字:
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class Solution {


    /**
     * 规律：
     * 1、从左到右，找第一个比后面大的字符，删除，k--， 如果有前导零，清零
     * 2、重复1，直到k = 0
     */
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k >= num.length()) return "0";
        StringBuilder builder = new StringBuilder(num);
        for(int i = 0; i < builder.length(); i++){
            int num1 = builder.charAt(i) - '0';
            int num2 = (i != builder.length() - 1 ? builder.charAt(i + 1) - '0' : Integer.MIN_VALUE);
            if(num1 > num2){//找出第一个比后面大的数，把他从num中删除掉
                builder.deleteCharAt(i);
                k--;
                //删除后，重新开始
                i = 0;
                //如果有前导零，删除所有的前导零
                while (i < builder.length() && builder.charAt(i) == '0'){
                    builder.deleteCharAt(i);
                    i = 0;
                }
                if(k == 0){
                    break;
                }
                i--;
            }
        }
        while (k != 0 && builder.length() > 0){
            builder.deleteCharAt(0);
            k--;
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

}
