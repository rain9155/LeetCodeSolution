package medium.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合,
 * 每个数字都有到字母的映射，除了 1 不对应任何字母。
 */
public class Solution {



    /**
     * 广度优先遍历：
     * 1、每次取一个数字，然后取出该数字对应的字符串
     * 2、取出之前的每个组合，然后在每个组合加上当前数字对应的字符串的每个字符
     * 3、更新之前的组合集
     * 4、重复1、2、3，直到每个数字都被取出来
     */
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return ret;
        String strs[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ret.add("");//初始状态，一个组合，没有字符存在
        for(int i = 0; i < digits.length(); i++){
            String str = strs[digits.charAt(i) - '0'];//取出每个数字对应的字符串
            List<String> temp = new ArrayList<String>();//暂存当前数字对应的字符串每个字符和上一次每个组合之间的组合集
            for(String s : ret){//取出之前的每个组合
                for(char c : str.toCharArray()){//取出每个数字对应的字符串的每个字符
                    temp.add(s + c);//在之前的组合加上当前字符
                }
            }
           ret = temp;//更新为最新的组合集
        }
        return ret;
    }

}
