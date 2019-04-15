package leetcode5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串
 */
public class Solution {

    /**
     * 蛮力法（O（n^3））
     * 1、遍历所有字串，然后反转字串；
     * 2、看字串与反转字串是否相同，如果相同，则为回文
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = s.substring(i, j + 1);
                if(str.equals((new StringBuilder(str)).reverse().toString()) && str.length() > ret.length())
                    ret = str;
            }
        }
        return ret;
    }

    /**
     * 中心扩展法（O(n^2)）：
     * 1、遍历字符串的每个字符和每个字符相邻的""；
     * 2、以这个字符为中心展开，以""为中心展开；（回文数为奇数时中心在回文中间的字符，回文数为偶数时中心在中间两个字符之间的"",例如 “abba” 的中心在两‘b’ 之间）
     * 3、找出回文数最大的回文
     */
    public String longestPalindrome2(String s) {
        if(s == null || s.length() < 1) return "";
        String ret = "";
        int end = 0, start = 0;
        for(int i = 0; i < s.length(); i++){
            int l1 = expandAroundCenter(s, i, i);//奇数回文情况的回文长度
            int l2 = expandAroundCenter(s, i, i + 1);//偶数回文情况回文长度
            int l = Math.max(l1, l2);//取回文长度最长的那个
            //记录下最新长度的回文在s中的位置
            if(l > end - start){
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }
        ret = s.substring(start, end + 1);
        return ret;
    }

    /**
     * 从s的left和right索引向两边展开，判断是否是回文，如果是回文，返回回文的长度，如果不是回文，结果返回0
     */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
