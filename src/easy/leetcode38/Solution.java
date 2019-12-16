package easy.leetcode38;

/**
 * 报数:
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 * 其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 * ps:
 * 题目的意思是对序列前一个数进行报数，数列第一项不是1吗，那第二项就报第一项的有1个1，输出11，
 * 然后第三项就在第二项的基础上报数，第二项是11，第三项不就是2个1么，然后输出21
 */
public class Solution {

    /**
     * O(n^2)
     * 使用递归：
     * n递归到1的时候直接返回1
     * 每当递归返回时，用一个temp暂时保存上次递归的报数序列，然后用concat计算当前递归深度的报数序列，然后返回当前递归深度的报数序列
     */
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String temp = countAndSay(n - 1);
        return concat(temp.toCharArray());
    }

    /**
     * 根据上次递归的结果计算当前递归深度的报数序列
     * @param temp 上次递归的报数序列
     * @return 返回当前递归深度的报数序列
     */
    private String concat(char[] temp){
        StringBuilder builder = new StringBuilder();//当前递归深度的索引
        int i = 0;//temp的索引
        while (i < temp.length){
            int j = 0;//记录每个字符的数量
            while (j + i < temp.length && temp[i]  == temp[j + i]){
                j++;
            }
            builder.append("" + j + temp[i]);
            i += j;
        }
        return builder.toString();
    }

}
