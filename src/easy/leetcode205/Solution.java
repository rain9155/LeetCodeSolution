package easy.leetcode205;

import java.util.*;

/**
 * 同构字符串:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class Solution {

    /**
     * 还有一个测试用例未通过
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, List<Integer>> mapS = new LinkedHashMap<>();
        Map<Character, List<Integer>> mapT = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            mapS.computeIfAbsent(c, character -> new ArrayList<>()).add(i);
        }
        for(int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            mapT.computeIfAbsent(c, character -> new ArrayList<>()).add(i);
        }
        if(mapS.size() != mapT.size()){
            return false;
        }
        Collection<List<Integer>> col1 = mapS.values();
        Collection<List<Integer>> col2 = mapT.values();
        Iterator<List<Integer>> iterator1 = col1.iterator();
        Iterator<List<Integer>> iterator2 = col2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()){
            List<Integer> list1 = iterator1.next();
            List<Integer> list2 = iterator2.next();
            if(list1.size() != list2.size()){
                return false;
            }
            for(int i = 0; i < list1.size(); i++){
                if(list1.get(i) != list2.get(i)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 哈希表:
     */
    public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else {
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
