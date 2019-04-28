package leetcode10;

/**
 * 正则表达式匹配：
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配，匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * '.' 匹配任意单个字符，
 * '*' 匹配零个或多个前面的元素。
 */
public class Solution {

    /**
     * 递归实现
     */
    public boolean isMatch(String s, String p) {

        //如果都为空则匹配成功
        if (p.isEmpty()) return s.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            //isMatch(s, p.substring(2))：看看忽略掉*前面的字符,看有没有可能剩下的p匹配上全部的s，所以将*以及*之前的一个字符删除后,再匹配之后的字符。所以p.substring(2)用来移动p
            //first_match && isMatch(.substring(1), p))：如果第一个已经匹配成功，并且第二个字符为*时，判断*能否匹配s后面的多个字符。所以s.substring(1)用来移动s
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(s.substring(1), p.substring(1));
        }

    }
}
