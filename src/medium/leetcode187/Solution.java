package medium.leetcode187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列:
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的10个字母长的序列（子串）。
 *
 * 示例:
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Solution {

    /**
     * 蛮力法：
     * 用一个set保存遍历过的s的字串（字串长度都为10），当某个字串在set中出现过时就把它添加进ret
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        if(s == null || s.length() < 20)  return ret;
        Set<String> set = new HashSet<>();
        for(int i = 0; i + 10 <= s.length(); i++){
            String subS = s.substring(i, i + 10);
            if(set.contains(subS) && !ret.contains(subS)){
                ret.add(subS);
            }
            set.add(subS);
        }
        return ret;
    }

}
