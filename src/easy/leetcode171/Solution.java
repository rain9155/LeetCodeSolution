package easy.leetcode171;

/**
 * Excel表列序号:
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 */
public class Solution {

    /**
     * 参考168题：26进制的计算
     */
    public int titleToNumber(String s) {
        int ret = 0;
        int power = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int num = c - 'A' + 1;
            ret += power * num;
            power *= 26;
        }
        return ret;
    }

}
