package easy.leetcode345;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转字符串中的元音字母：
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class Solution {

    /**
     * 双指针：
     */
    public String reverseVowels(String s) {
        if(s == null) return null;
        int len = s.length();
        int p1 = 0;
        int p2 = len - 1;
        char[] chars = s.toCharArray();
        List<Character> words = new ArrayList<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('I');
            add('O');
            add('U');
        }};
        while(p1 < p2){
            if(words.contains(chars[p1]) && words.contains(chars[p2])){
                char temp = chars[p1];
                chars[p2] = chars[p1];
                chars[p1] = temp;
                p1++;
                p2--;
            }else if(!words.contains(chars[p1])){
                p1++;
            }else if(!words.contains(chars[p2])){
                p2--;
            }else{
                p1++;
                p2--;
            }
        }
        return String.valueOf(chars);
    }

}
