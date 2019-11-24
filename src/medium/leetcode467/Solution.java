package medium.leetcode467;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 环绕字符串中唯一的子字符串:
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
 * 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 
 * 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
 *
 * 示例 1:
 * 输入: "a"
 * 输出: 1
 * 解释: 字符串 S 中只有一个"a"子字符。
 * 示例 2:
 * 输入: "cac"
 * 输出: 2
 * 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 * 输入: "zab"
 * 输出: 6
 * 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
 */
public class Solution {

    /**
     * 动态规划：
     * 用一个长度为26的dp数组，记录每个字母结尾所能组成的最长连续子串的长度，这里的连续表示连续字母或首尾相连
     * 如zab，以z结尾的有z，长度为1，以a结尾的有za、a，最长长度为2，以b结尾的有zab、ab、b，最长长度为3
     * 所以结果就是1 + 2 + 3 = 6
     */
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 0) return 0;
        int[] dp = new int[26];//记录以每个字母结尾所能组成的最长连续子串的长度，这里的连续表示连续字母或首尾相连
        char[] chars = p.toCharArray();
        int len = 1;
        dp[chars[0] - 'a'] = 1;
        for(int i = 1; i < chars.length; i++){
            //连续字母如ab或首尾相连如za，长度累加
            if(chars[i] - chars[i - 1] == 1 || chars[i - 1] - chars[i] == 25){
                len++;
            }else {
                //不是连续字母或不是首尾相连，回到初始值1
                len = 1;
            }
            //取最大的，覆盖掉重复的和短序列
            dp[chars[i] - 'a'] = Math.max(len, dp[chars[i] - 'a']);
        }
        int ret = 0;
        //把所有长度相加，就是p的非空子串在s中的匹配次数
        for (int l : dp){
            ret += l;
        }
        return ret;
    }

}
