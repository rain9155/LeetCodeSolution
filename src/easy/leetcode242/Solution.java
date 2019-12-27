package easy.leetcode242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 有效的字母异位词:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Solution {

    /**
     * 哈希表：
     * 1、首先用哈希表记录s中每个字符的出现次数
     * 2、然后再遍历t，看t中的字符出现的次数与s是否相同
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(map.getOrDefault(c, 0) == 0) return false;
            map.put(c, map.get(c) - 1);
        }
        for(Character c : map.keySet()){
            if(map.get(c) != 0) return false;
        }
        return true;
    }

    /**
     * 排序：
     * 如果两个字符串是有效的字母异位词，那么排序后，两个字符串相同
     */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

}
