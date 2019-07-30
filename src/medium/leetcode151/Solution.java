package medium.leetcode151;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻转字符串里的单词:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Solution {

    public String reverseWords(String s) {
        if(s == null ) return s;
        s = s.trim();
        if(s.length() == 0) return s;
        List<String> words = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == ' '){
                if(builder.length() == 0){
                    continue;
                }
                words.add(builder.toString());
                builder = new StringBuilder();
            }else {
                builder.append(c);
            }
        }
        if(builder.length() != 0) words.add(builder.toString());
        builder = new StringBuilder();
        for(int i = words.size() - 1; i >= 0; i--){
            builder.append(words.get(i)).append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}
