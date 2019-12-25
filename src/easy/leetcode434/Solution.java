package easy.leetcode434;

/**
 * 字符串中的单词数:
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class Solution {

    /**
     * 跳过多余的空格：
     * 用一个指针p，遇到非空格字符，忽略；
     * 如果遇到空格，就代表遇到单词的结尾，然后计数器加一，然后p向后移动，跳过多余的空格直到遇到下一个单词的开头
     */
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        int p = 0;
        int count = 0;
        while (p < s.length() && s.charAt(p) == ' '){
            p++;
        }
        while (p < s.length()){
            if(s.charAt(p) == ' '){
                count++;
                while (p < s.length() && s.charAt(p) == ' '){
                    p++;
                }
            }else {
                if(p == s.length() - 1){
                    count++;
                }
                p++;
            }
        }
        return count;
    }

    /**
     * 记录单词开头：
     * 在s中，单词的开头就是start = （空格 + 单词的第一个字符）， 有多少个start就有多少个单词
     * 所以，如果当前遍历到的字符不是空格并且字符的前一个字符是空格，就说明遇到了start，计数器加一
     */
    public int countSegments2(String s) {
        if(s.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }

}
