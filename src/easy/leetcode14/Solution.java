package easy.leetcode14;

/**
 * 查找字符串数组中的最长公共前缀
 */
public class Solution {

    /**
     * 水平扫描法：O(nm),n为字符串数组的长度，m为每个字符串的长度
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

}
