package medium.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合,
 * 每个数字都有到字母的映射，除了 1 不对应任何字母。
 *
 * 示例 1:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 
 * 示例 2:
 * 输入：digits = ""
 * 输出：[]
 * 
 * 示例 3:
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序number
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

    /**
     * 深度优先遍历（回溯）：
     * 1、首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作，回溯过程中维护一个字符串，表示已组合的字母排列
     * 2、每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面
     * 3、然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列，把这个字母排列加入结果中
     * 4、然后进行回退操作，遍历其余的字母
     */
    public List<String> letterCombinations2(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return ret;
        }
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, strs, 0, ret, new StringBuilder());
        return ret;
    }

    public void backtrack(String digits, String[] strs, int index, List<String> ret, StringBuilder builder) {
        if(index == digits.length()) {
            //处理到电话号码尾部，表示得到一个完整的字母排列
            ret.add(builder.toString());
        }else {
            //每次处理电话号码的一个数字，遍历该数字对应的字母列表，将每个字母加入到已有的字母排列中
            char digit = digits.charAt(index);
            String str = strs[digit - '0'];
            for(char c : str.toCharArray()) {
                builder.append(c);
                backtrack(digits, strs, index + 1, ret, builder);
                //回溯过程中删除已加入的字母，下次循环加入新的字母
                builder.deleteCharAt(index);
            }
        }
    }

}
