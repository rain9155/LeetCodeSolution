package medium.leetcode151;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻转字符串里的单词:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
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
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Solution {

    /**
     * 双指针：
     * 先使用双指针把s分隔成一个个单词，然后再把单词拼接成反转后的s
     * 1、定义两个指针p1，p2，初始化指向0位置
     * 2、移动p1，直到遇到第一个字符，这时p1指向单词的开头，接着移动p2，直到遇到第一个空格，这时p2指向单词的结尾
     * 3、截取p1到p2的子串，然后重复2步骤，直到p1和p2都移动到s末尾
     */
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int len = s.length();
        List<String> words = new ArrayList<>();
        StringBuilder ret = new StringBuilder();
        int p1 = 0, p2 = 0;
        //把字符串分隔成一个个单词，并保存到列表中
        while(p1 < len && p2 <= len){
            if(s.charAt(p1) == ' '){
                p1++;
                p2 = p1;
            }else if(p2 < len && s.charAt(p2) != ' '){
                p2++;
            }else{
                String word = s.substring(p1, p2);
                words.add(word);
                p1 = p2;
            }
        }
        //从后往前遍历单词列表，拼接成翻转后字符串
        for(int i = words.size() - 1; i >= 0; i--){
            String word = words.get(i);
            ret.append(word);
            if(i != 0){
                ret.append(" ");
            }
        }
        return ret.toString();
    }

}
