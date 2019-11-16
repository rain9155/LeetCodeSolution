package easy.leetcode409;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 最长回文串:
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Solution {

    /**
     * 哈希表：
     * 记最长回文串长度为len，对于每个字母，假设它出现了 v 次，
     * 如果v为偶数，那么该v个字母一定可以构成回文字符串，所以len = len + v
     * 如果v为奇数，那（v - 1）一定为偶数，那么该v - 1个字母一定可以构成回文字符串，所以len = len + (v - 1)，当len加完后，如果len还是偶数，就把v减去的1加上，构成回文字符串的中心，否则不加
     */
    public int longestPalindrome(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> cache = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            cache.put(
                    s.charAt(i),
                    cache.getOrDefault(s.charAt(i), 0) + 1);
        }
        int ret = 0;
        Set<Character> keySet = cache.keySet();
        for(Character c : keySet){
            int count = cache.get(c);
            if(count % 2 == 0){
                ret += count;
            }else{
                ret += (count - 1);
                if(ret % 2 == 0)
                    ret++;
            }
        }
        return ret;
    }

}
