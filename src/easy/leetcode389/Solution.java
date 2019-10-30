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

}
