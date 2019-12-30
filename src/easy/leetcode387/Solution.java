package easy.leetcode387;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符：
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 * s = "leetcode395"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 *  
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution {

    /**
     * 哈希表：
     * 1、第一次遍历使用哈希表来保存每个字符出现的次数
     * 2、第二次遍历看哪个字符第一次出现了一次
     */
    public int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }

}
