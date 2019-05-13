package medium.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成:
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Solution {

    /**
     * O(2^n * n)
     * 暴力法, 使用递归生成2^(2*n)个所有括号的组合，然后判断每个组合是否有效
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        generateBrackets(new char[n * 2], 0, ret);
        return ret;
    }

    /**
     * 递归生成所有括号组合
     * @param current 当前递归深度的括号组合
     * @param pos 当前的递归深度，即current的索引处
     * @param result 括号组合结果
     */
    private void generateBrackets(char[] current, int pos, List<String> result){
        if(pos == current.length){
            if(valid(current)) result.add(new String(current));
            return;
        }
        current[pos] = '(';
        generateBrackets(current,pos + 1, result);
        if(pos == 0) return;
        current[pos] = ')';
        generateBrackets(current, pos + 1, result);
    }

    /**
     * 判断给定的括号组合是否有效，有效的标准是左右括号数量相等并且左括号一定要有右括号匹配
     * @param current 括号组合
     * @return 有效返回true，否则返回false
     */
    private boolean valid(char[] current){
        int ban = 0;
        for(char c : current){
            if(c == '(') ban++;
            else ban--;
            if (ban < 0) return false;
        }
        return ban == 0;
    }

    /**
     * O(2^n)
     * 优化后的暴力法，在递归的过程中，记录左右括号的数量，当出现括号数量不匹配时，不添加进结果，当满足括号数量条件时才添加进结果
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ret = new ArrayList<String>();
        generateBrackets2(new char[n * 2], 0, 0, 0, ret);
        return ret;
    }

    /**
     * 递归生成所有括号组合,并在递归的过程中判断是否满足条件
     * @param current 当前递归深度的括号组合
     * @param pos 当前的递归深度，即current的索引处
     * @param countLeft 当前的递归深度，左括号数量
     * @param countRight 当前的递归深度，右括号数量
     * @param result 括号组合结果
     */
    private void generateBrackets2(char[] current, int pos, int countLeft, int countRight, List<String> result){
        if(countLeft < countRight) return;
        if(countLeft > countRight && pos == current.length) return;
        if(pos == current.length){
            result.add(new String(current));
            return;
        }
        current[pos] = '(';
        generateBrackets2(current, pos + 1, countLeft + 1, countRight, result);
        current[pos] = ')';
        generateBrackets2(current, pos + 1, countLeft, countRight + 1, result);
    }

}
