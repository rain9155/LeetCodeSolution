package medium.leetcode93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) return ret;
        backtrack(ret, new LinkedList<>(), s, -1, 0);
        return ret;
    }

    private void backtrack(List<String> ret, LinkedList<String> temp, String s, int pre, int cur){
        if(valid(pre + 1, cur + 1, s) && temp.size() == 3){
            if(valid(cur + 2, s.length(), s)){
                temp.add(s.substring(cur + 2));
            }else {
                return;
            }
        }
        if(temp.size() == 4){
            ret.add(String.join(".", temp));
            return;
        }
        for(int i = cur; i < pre + 4; i++){
            temp.add(s.substring(pre + 1, i + 1));
            backtrack(ret, temp, s, pre + 1, i + 1);
            temp.removeLast();
        }
    }

    private boolean valid(int p1, int p2, String s) {
        String temp = s.substring(p1, p2);
        if(temp.charAt(0) == '0') return false;
        if(Integer.valueOf(temp) > 255) return false;
        return true;
    }

}
