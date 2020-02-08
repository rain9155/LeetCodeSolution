package medium.leetcode394;

import java.util.Stack;

/**
 * 字符串解码：
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Solution {

    /**
     * 双栈：
     * 1、使用两个栈numStack和strStack，numStack用来记录连续子串重复的次数，strStack用来记录重复的连续子串
     * 2、遍历s，如果遇到数字或字符，就分别用count和ret拼接，当遇到‘[’时，就把count重复次数和ret连续子串分别入栈
     * 3、如果遇到']'，就代表准备出栈，这时从numStack栈顶中取出记录的重复次数，把连续子串重复拼接后再和strStack栈顶连续子串拼接成新的ret
     * 4、重复2、3步骤直到遍历完s，ret就是返回结果
     */
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        char[] chars = s.toCharArray();
        StringBuilder ret = new StringBuilder();
        int count = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c >= '0' && c <= '9'){
                count = count * 10 + Integer.parseInt("" + c);
            }else if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                ret.append(c);
            }else if(c == '[') {
                numStack.push(count);
                strStack.push(ret.toString());
                count = 0;
                ret = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int repeat =  numStack.pop();
                for(int j = 0; j < repeat; j++) {
                    tmp.append(ret);
                }
                ret = new StringBuilder(strStack.pop() + tmp);
            }
        }
        return ret.toString();
    }



}
