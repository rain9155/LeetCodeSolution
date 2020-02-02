package medium.leetcode139;

import java.util.List;

/**
 * 单词拆分:
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 *  * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode395", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode395" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution {


    /**
     * O(n^2),超时
     * 回溯法：
     * 每一层逐个取出s的字串，然后判断它是否包含在wordDict中，如果包含就继续递归下去，如果不包含，就再继续取字串
     * 当递归返回时，如果返回false表示不包含，就从上次停下的地方再继续取字串
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private boolean wordBreak(String s, List<String> wordDict, int start) {
        if(start >= s.length()) return true;
        for(int i = start; i < s.length(); i++){
            String word = s.substring(start, i + 1);
            if(wordDict.contains(word) && wordBreak(s, wordDict, i + 1)){
                return true;
            }
        }
        return false;
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    /**
     * 优化回溯算法：
     * 如果出现s = “aaaaaab”, wordDict = [a, aa, aaa, aaaa]这种情况，s中每取出一个字串，都包含在wordDict中，就会导致重复执行多次递归
     * 所以就要用一个meto数组记录已经访问过并确定了从start开始是否可以再划分单词，当下次回溯时，如果meto中有，就直接返回meto中的记录就行
     */
    private boolean wordBreak(String s, List<String> wordDict, int start, Boolean[] meto) {
        if(start >= s.length()) return true;
        if(meto[start] != null) return meto[start];//之前已经确认过从start开始划分的单词是否包含在wordDict中
        for(int i = start; i < s.length(); i++){
            String word = s.substring(start, i + 1);
            if(wordDict.contains(word) && wordBreak(s, wordDict, i + 1, meto)){
                return meto[start] = true;
            }
        }
        return meto[start] = false;
    }

    /**
     * 动态规划;
     * 对于s = leetcode395, 如果s划分后在wordDict中，则把s划分成两部分leet 和 code也在wordDict中，同理，如果leet在wordDict中，则把leet逐个划分成两部分""和leet也在wordDict中
     * 所以对于s，我们用i和j两个指针，用i从0到s.length划分s的字串，j则继续把从[0 ... i]的字串继续划分成[0 ... j]和[j ... i]的子串, 然后判断[0 ... j]和[j ... i]是否包含在wordDict中
     * 如果[0 ... j]和[j ... i]包含在wordDict中则，[0 ... i]包含在wordDict中，则dp[i] = true, 否则dp[i] = false, 然后我们初始化dp[0] = true, 表示空字符串一定包含在wordDict中，就这样直到i == s.length
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        if(s == null) return true;
        if(wordDict == null || wordDict.size() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String temp = s.substring(j, i);
                if(dp[j] && wordDict.contains(temp)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
