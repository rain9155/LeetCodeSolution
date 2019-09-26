package medium.leetcode318;

/**
 * 最大单词长度乘积:
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class Solution {

    /**
     * 位运算：
     * 用二进制的一位表示某一个字母是否出现过，0表示没出现，1表示出现。
     * "abcd"二进制表示00000000 00000000 00000000 00001111
     * "bc"二进制表示00000000 00000000 00000000 00000110。
     * 当两个字符串没有相同的字母时，二进制数与的结果为0
     * 然后遍历words，根据相应的二进制位，当两个单词不相等，取长度乘积，最后取最大值
     */
    public int maxProduct(String[] words) {
        if(words.length == 0) return 0;
        int[] bit = new int[words.length];
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                bit[i] |=  1 << (word.charAt(j) - 'a');
            }
        }
        int maxLen = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((bit[i] & bit[j]) == 0){
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }

}
