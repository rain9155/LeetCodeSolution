package easy.leetcode58;

/**
 * 最后一个单词的长度:
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution {

    /**
     * 先把s的头尾空格去掉，再用一个指针指向s的后面，从后面开始计数，遇到空格就计数完毕
     */
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int p1 = s.length() - 1;
        int len = 0;
        char[] chars = s.toCharArray();
        while (p1 >= 0 && chars[p1] != ' '){
            len++;
            p1--;
        }
        return len;
    }

}
