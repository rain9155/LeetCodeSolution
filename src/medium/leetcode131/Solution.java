package medium.leetcode131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Solution {

    List<List<String>> ret = new ArrayList<>();

    /**
     * 回溯算法：
     * 对aab进行分割，可以分割成如下：
     * a a b
     * a ab
     * aa b
     * aab
     *每一层的递归都是先分割一个，然后在分割两个，直到s.length
     * 所以用一个start下标作为每一层分割s的起点，然后用i控制分割的终点，初始化i = start，利用start和i取出s中的字串，然后判断是否是回文，如果是回文就向下递归并加入列表
     * 当向下递归时就把i + 1作为下一层分割的起点，当回溯时，就把i 加 1，当start == s.length时就代表这个分割满足条件
     */
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return ret;
        partition(new LinkedList<>(), s, 0);
        return ret;
    }

    private void partition(LinkedList<String> tempList, String s, int start){
        if(start == s.length()){
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String str = s.substring(start, i + 1);
            if(isPalindromes(str)){
                tempList.add(str);
                partition(tempList, s, i + 1);
                tempList.removeLast();
            }
        }
    }


    private boolean isPalindromes(String s){
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)){
           start++;
           end--;
        }
        return start >= end;
    }

}
