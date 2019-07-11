package medium.leetcode120;

import java.util.List;

/**
 * 三角形最小路径和:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution {

    /**
     * 二维dp（动态规划）：
     * 从triangle的底部往上求，创建一个二维数组dp，一开始把dp的最后一行填充为triangle的最后一行的数字
     * 然后从triangle的倒数第二行开始求，每一列的数字都是依赖于triangle当前行的当前列的数字和dp的上一行的相邻两个数字的最小数字，即：dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
     * 最后dp[0][0]就是结果
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[n][m];
        //先填充最后一行
        for(int j = 0; j < triangle.get(triangle.size() - 1).size(); j++){
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size(); j++){
                dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 一维dp(动态规划):
     * 因为二维dp中每一个元素都依赖于dp[i + 1][j], dp[i + 1][j + 1]，并只会把更新后的值放在dp[i][j], 而dp[i + 1][j + 1]的值会继续使用
     * 所以我们可以把[j]维去掉，首先把dp填充为triangle的最后一行的数字，然后然后从triangle的倒数第二行开始求
     * 每相邻两个数字的最小数字和triangle当前行的当前列的数字的和放在dp的当前位置j
     * 最后dp[0]就是结果
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        for(int j = 0; j < triangle.get(triangle.size() - 1).size(); j++){
            dp[j] = triangle.get(triangle.size() - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0; j < list.size(); j++){
                dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


}
