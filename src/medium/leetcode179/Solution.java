package medium.leetcode179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数:
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Solution {

    /**
     * 自定义排序规则：
     * 对于nums排序后要想组成最大数，则不能按照大小排序，而是按照数字的最高位排序，数字的最高位越高，数字排得越前
     * 所以首先把所有数字转成字符串，自定义一种排序方式 比较 s1 + s2 和 s2 + s1那个更大，如果s1 + s2大，则s1排前面，如果s2 + s1大，则s2排前面
     */
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        if(strNums[0].equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        for(String s : strNums){
            builder.append(s);
        }
        return builder.toString();
    }

}
