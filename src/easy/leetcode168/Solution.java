package easy.leetcode168;

/**
 * Excel表列名称:
 *给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 */
public class Solution {

    /**
     * 模拟26进制：
     * 先把n减一，这样才能把 A-1 ~ Z-26 映射为 A-0 ~ Z-25
     */
    public String convertToTitle(int n) {
        if(n < 0) return "";
        StringBuilder builder = new StringBuilder();
        while (n != 0){
            n--;
            int remainder = n % 26;
            char c = (char) ('A' + remainder);
            builder.append(c);
            n /= 26;
        }
        return builder.reverse().toString();
    }

}
