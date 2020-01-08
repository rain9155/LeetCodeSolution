package medium.leetcode49;

import java.util.*;

/**
 * 字母异位词分组:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序
 */
public class Solution {

    /**
     * O(nklogk): 其中N 是 strs 的长度，而 K 是 strs 中字符串的最大长度
     * 按排序数组分类：
     * 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
     * 维护一个映射 map : {String -> List}，其中每个键是一个排序字符串
     * 然后遍历这个strs，取出它的每一个字符K，排序，记排序后的字符串为T
     * 然后看map中是否有这个T，如果有，就取出T对应的List，把K放入List中，如果没有，就把在map中建立{T -> List}的映射，并把K放入List中
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs== null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String sortStr = sort(strs[i]);
            if(map.get(sortStr) == null){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortStr, list);
            }else {
                List<String> list = map.get(sortStr);
                list.add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 字符串排序
     */
    private String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    /**
     * O(nk)
     * 按计数分类：
     * 当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词
     * 维护一个映射 map : {String -> List}，其中每个键是一个计数排序的字符串
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for (String s : strs) {
            Arrays.fill(counts, 0);
            //对每个字符出现的次数计数
            for (char c : s.toCharArray()) counts[c - 'a']++;
            //构造map的键，即一个用 ＃ 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(counts[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
