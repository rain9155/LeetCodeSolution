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
     * 参考：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * 双栈：
     */
    public String decodeString(String s) {
        if(s.length() == 0) return "";
        char[] chars = s.toCharArray();
        StringBuilder ret = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int count = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == '[') {
                numStack.push(count);
                strStack.push(ret.toString());
                count = 0;
                ret = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_count =  numStack.pop();
                for(int j = 0; j < cur_count; j++) {
                    tmp.append(ret);
                }
                ret = new StringBuilder(strStack.pop() + tmp);
            } else if(c >= '0' && c <= '9'){
                count = count * 10 + Integer.parseInt("" + c);
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }



}
