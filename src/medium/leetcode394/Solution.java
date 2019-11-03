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

    public String decodeString(String s) {
        if(s.length() == 0) return "";
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int flag = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '['){
                if(c == '['){
                    flag++;
                }
                charStack.push(String.valueOf(c));
            }else if(c == ']'){
                flag--;
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder();
                while (!charStack.isEmpty()){
                    if(charStack.peek().equals("[")){
                        charStack.pop();
                        break;
                    }
                    temp.append(charStack.pop());
                }
                temp.reverse();
                String tempStr = temp.toString();
                for(int j = 1; j < count; j++){
                    temp.append(tempStr);
                }
                if(flag > 0){//有嵌套
                    charStack.push(temp.toString());
                }else {
                    available(builder, charStack);
                    builder.append(temp);
                }
            }else {
                int j = i;
                StringBuilder temp = new StringBuilder();
                while (j < chars.length && chars[j] != '['){
                    temp.append(chars[j]);
                    j++;
                }
                numStack.push(Integer.valueOf(temp.toString()));
                i = j - 1;
            }

        }
        available(builder, charStack);
        return builder.toString();
    }

    private void available(StringBuilder builder, Stack<String> charStack) {
        if(!charStack.isEmpty()){
            StringBuilder temp = new StringBuilder();
            while (!charStack.isEmpty()){
                temp.append(charStack.pop());
            }
            builder.append(temp.reverse().toString());
        }
    }

}
