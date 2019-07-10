package easy.leetcode118;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行,
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {

    /**
     * 找规律：
     * numRows就是生成杨辉三角的行数，从1到numRows的每个数字代表每一行数字的个数
     * 每一行的第一个数字和最后一个数字都是1，其他的都是根据上一行的两个数相加得出：规律就是当前行的j位置的数字 = 上一行j位置数字 + 上一行j - 1位置的数字
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>(numRows);
        if(numRows <= 0) return ret;
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>(i + 1);
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    list.add(1);
                }else {
                    List<Integer> preList = ret.get(i - 1);
                    int num1 = preList.get(j - 1);
                    int num2 = preList.get(j);
                    list.add(num1 + num2);
                }
            }
            ret.add(list);
        }
        return ret;
    }

}
