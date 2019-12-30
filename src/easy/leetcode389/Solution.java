package easy.leetcode389;

/**
 * 找不同:
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class Solution {

    /**
     * 哈希表：
     * 1、用一个26大小的数组保存s每个字符出现的次数
     * 2、遍历一遍t，找出t中没有在数组中出现的字符
     */
    public char findTheDifference(String s, String t) {
        int[] dp = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 97;
            dp[index]++;
        }

        for(int i = 0; i < t.length(); i++){
            int index = t.charAt(i) - 97;
            dp[index]--;
            if(dp[index] < 0){
                return t.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 位运算：
     * 对两个字符串的字符一起做一个异或运算，唯一出现的那个字符就会被找出来
     */
    public char findTheDifference2(String s, String t) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            int sNum = s.charAt(i) - 'a';
            ret ^= sNum;
        }
        for(int i = 0; i < t.length(); i++){
            int tNum = t.charAt(i);
            ret ^= tNum;
        }
        return (char) (ret + 67);
    }

}
