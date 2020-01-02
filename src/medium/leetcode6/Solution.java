package medium.leetcode6;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换：
 * 将一个给定字符串根据给定的行数numRows，以从上往下、从左到右进行 Z 字形排列
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Solution {

    /**
     * O(n)
     * 每一行用StringBuilder表示，和List组成一个表格，
     * 然后从左往右遍历S，逐个取出字符，把字符填表格，
     * 先从上往下放入List中，然后再从下往上放入List中，最后逐行取出拼接成字符串返回
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0; i < Math.min(numRows, s.length()); i++){
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean down = false;
        for(char c : s.toCharArray()){
            list.get(curRow).append(c);
            if(curRow == 0)
                down = true;
            if(curRow == numRows - 1)
                down = false;
            curRow += down ? 1 : -1;
        }
        StringBuilder strBuilder = new StringBuilder(s.length());
        for(StringBuilder str : list){
            strBuilder.append(str);
        }
        return strBuilder.toString();
    }

}
