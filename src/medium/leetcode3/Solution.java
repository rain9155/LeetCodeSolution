package medium.leetcode3;

import java.util.*;

/**
 * 无重复字符的最长子串：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {

    /**
     * O(n^3)
     * 蛮力法：
     */
    public int lengthOfLongestSubstring(String s) {
        int count = 0, t;
        List<Character> list = new ArrayList<Character>();
        //1、2个for循环取s的子字符串集合
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                //第3个for循环判断s的子字符串是否符合（1、不含有重复元素的条件）
                list.clear();
                for(t = i; t <= j; t++){
                    char c = s.charAt(t);
                    if(list.contains(c)){
                        break;
                    }
                    list.add(c);
                }
                //代表子字符串符合条件，取最大值
                if(t == j + 1){
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    /**
     * O(2n) = O(n)
     * Set + 滑动窗口：
     * 1、不断移动[i,j）（移动i或j），移动过程中记录最大 子字符串 的长度，在[i,j)范围内的字符串永远不会重复
     * 2、第j个指向的元素与[i, j - 1]内的元素没有重复时，把它添加进集合[i, j]，并移动j
     * 3、第j个指向的元素与[i, j - 1]内的元素重复时，j停止，i移动，直到[i, j - 1]内的重复元素被移除，此时i停止，j才继续移动
     */
    public int lengthOfLongestSubstring2(String s) {
        int count = 0, i = 0, j = 0;
        int length = s.length();
        Set<Character> set = new HashSet<Character>();
        while(i < length && j < length){
            char c = s.charAt(j);
            if(!set.contains(c)){//第j个指向的元素与[i,j)范围内的字符串没有重复时，把它添加进集合，并移动j
                set.add(c);
                j++;
                count = Math.max(count, j - i);
            }else {//第j个指向的元素与[i, j - 1]内的元素重复时，移动i，直到重复元素被移除
                set.remove(s.charAt(i));
                i++;
            }
        }
        return count;
    }

    /**
     * O(n)
     * 哈希表 + 滑动窗口：
     * 1、不断移动[i,j）（移动i或j），移动过程中记录最大 子字符串 的长度，在[i,j)范围内的字符串永远不会重复
     * 2、第j个指向的元素与[i, j - 1]内的元素重复时，i直接跳到重复元素所在索引 + 1的位置 或者保持不动（因为回溯的话会造成[i, j)内再次出现重复元素），然后j继续移动
     * 3、第j个指向的元素与[i, j - 1]内的元素没有重复时，把字符和索引（j + 1,指向j指向的下一个元素）的映射添加进集合，j继续移动
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int p1 = 0, p2 = 0;
        int maxLen = 0;
        while(p2 < s.length()){
            if(!map.containsKey(s.charAt(p2))){//如果哈希表中没有字符与该索引的映射，直接put字符和索引的映射
                map.put(s.charAt(p2), p2);
            }else{
                p1 = Math.max(p1, map.get(s.charAt(p2)) + 1);//如果哈希表中已经存在字符与该索引的映射，说明出现重复元素，把p1跳到最靠近p2的位置，防止p1回溯
                map.put(s.charAt(p2), p2);
            }
            p2++;//移动p2
            maxLen = Math.max(maxLen, p2 - p1);
        }
        return maxLen;
    }

}
