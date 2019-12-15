package easy.leetcode14;

/**
 * 查找字符串数组中的最长公共前缀:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {

    /**
     * O(nm),n为字符串数组的长度，m为每个字符串的长度
     * 水平扫描法：
     * 1、如果strs不为空，把strs的第一个字符串作为默认前缀prefix
     * 2、每个取strs中的后一个字符串与prefix比较，如果有共同的前缀，则更新prefix为最新的共同前缀，如果没有就返回“”，就表示字符串数组中没有最长公共前缀
     * 3、重复第2步，直到遍历完字符数组
     */
    public String longestCommonPrefix(String[] strs) {
       if(strs.length == 0) return "";
       String prefix = strs[0];
       for(int i = 1; i < strs.length; i++){
           while (strs[i].indexOf(prefix) != 0){
               prefix = prefix.substring(0, prefix.length() - 1);
               if(prefix.isEmpty()) return "";
           }
        }
        return prefix;
    }

    /**
     * O(n^2)
     * 每次取出strs第一个字符串的前缀，然后逐个遍历剩余的str看是否有匹配的前缀
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0 || strs[0].length() == 0) return "";
        String prefix = "";
        for(int i = 1; i <= strs[0].length(); i++){
            prefix = strs[0].substring(0, i);
            int j = 1;
            while (j < strs.length && strs[j].indexOf(prefix) == 0){
                j++;
            }
            if(j < strs.length){
                prefix =  prefix.substring(0, prefix.length() - 1);
                break;
            }
        }
        return prefix;
    }


    //3、可以使用字典树

}
