package leetcode3;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class Solution {

    /**
     * 蛮力法(O(n^3))
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
     * 滑动窗口方法;（O(2n) = O(n)）
     * 1、不断移动[i,j）（移动i或j），移动过程中记录最大 子字符串 的长度
     * 2、在[i,j)范围内的字符串永远不会重复
     * 3、第j个指向的元素与[i, j - 1]内的元素没有重复时，把它添加进集合[i, j]，并移动j
     * 4、第j个指向的元素与[i, j - 1]内的元素重复时，j停止，i移动，直到[i, j - 1]内的重复元素被移除，此时i停止，j才继续移动
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
     * 优化的滑动窗口方法：（O(n)）
     * 1、不断移动[i,j）（移动i或j），移动过程中记录最大 子字符串 的长度
     * 2、在[i,j)范围内的字符串永远不会重复
     * 3、第j个指向的元素与[i, j - 1]内的元素重复时，j停止，i直接跳到重复元素所在索引（先前的j + 1）
     * 4、第j个指向的元素与[i, j - 1]内的元素没有重复时，把字符和索引（j + 1,指向j指向的下一个元素）的映射添加进集合，j继续移动
     */
    public int lengthOfLongestSubstring3(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();//key存字符，value存字符索引
        for(int i = 0, j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(i, map.get(c));//保证跳到重复元素所在索引的最靠近j的那个
            }
            count = Math.max(count, j - i + 1);
            map.put(c, j + 1);
        }
        return count;
    }

}
