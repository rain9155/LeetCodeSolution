package medium.leetcode91;

/**
 * 解码方法:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution {

    /**
     * 动态规划：
     * 状态转移公式：count[i] = count[i - 1] + count[i - 2]
     * i是遍历s时的索引，每次遍历时取出取出到i为止的最后两个数字，记为lastTwoNum，记lastTwoNum的第一个数为preLastNum， 第二个数为lastNum，然后根据lastTwoNum是否大于26分为两种情况：
     *  第一种情况 lastTwoNum > 26：
     *      又分2种情况：
     *            （1）lastNum == 0 && preLastNum != 0，如170，任何组合都无法解析，所以返回0
     *            （2）lastNum != 0 && preLastNum != 0，如171，171的组合等于17的组合
     * 第二种情况 lastTwoNum <= 26：
     *      又分4种情况：
     *             (1) lastNum != 0 && preLastNum != 0,如121，121的组合等于12的组合加1的组合
     *             (2) lastNum == 0 && preLastNum != 0，如120, 120的组合等于1的组合
     *             (3) lastNum != 0 && preLastNum == 0, 如102，102的组合等于1的组合
     *             (4)  lastNum == 0 && preLastNum == 0, 如100，任何组合都无法解析，所以返回0
     * 初始化count[0] = 1, 如果s的第一个数为零，直接返回0，否则初始化count[1] = 1, 最后count的最后一个数就是结果
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        for(int i = 0; i < s.length(); i++){
            int lastNum = s.charAt(i) - 48;//取出到i为止的最后一个数字
            if(i == 0){
                count[i + 1] = 1;
                if(lastNum == 0) return 0;
            }else {
                int preLastNum = s.charAt(i - 1) - 48;//取出到i为止的最后一个数字的前一个数字
                String lastTwoNum = s.substring(i - 1, i + 1);//取出到i为止的最后两个数字
                if(Integer.valueOf(lastTwoNum) <= 26){//如果最后两个数小于26，分四种情况
                    if(lastNum != 0 && preLastNum != 0){//第一种情况，如121，121的组合等于12的组合加1的组合
                        count[i + 1] = count[i] + count[i - 1];
                    }else if (lastNum == 0 && preLastNum != 0){//第二种情况，如120, 120的组合等于1的组合
                        count[i + 1] = count[i - 1];
                    }else if(lastNum != 0){//第三种情况，如102，102的组合等于1的组合
                        count[i + 1] = count[i - 1];
                    }else {//第四种情况，如100，任何组合都无法解析，所以返回0
                        return 0;
                    }
                }else {//如果最后两个数字大于26，分两种情况讨论
                    //第一种情况，如170，任何组合都无法解析，所以返回0
                    if(lastNum == 0 && preLastNum != 0) return 0;
                    //第二种情况，如171，171的组合等于17的组合
                    count[i + 1] = count[i];
                }
            }
        }
        return count[s.length()];
    }

}
