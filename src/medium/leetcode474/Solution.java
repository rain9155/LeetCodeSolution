package medium.leetcode474;

import java.util.HashMap;
import java.util.Map;

/**
 * 一和零:
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class Solution {

    /**
     * 通过80%
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0) return 0;
        //保存每个位串中1的个数
        Map<String, Integer> map = new HashMap<>(strs.length);
        for(String str : strs){
            map.put(str, bitCount(str));
        }
        int[][] cache = new int[strs.length][2];
        int[] dp = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            String num = strs[i];
            int oneCount = map.get(num);//1的个数
            int zoreCount = num.length() - oneCount;//0的个数
            if(i == 0 && oneCount <= n && zoreCount <= m){
                    dp[0] = 1;
                    cache[0][0] = oneCount;
                    cache[0][1] = zoreCount;
            }else {
                if(oneCount > n || zoreCount > m){
                    continue;
                }
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(oneCount + cache[j][0] <= n && zoreCount + cache[j][1] <= m){
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                        cache[i][0] = Math.max(oneCount + cache[j][0], cache[i][0]);
                        cache[i][1] = Math.max(zoreCount + cache[j][1], cache[i][1]);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : dp){
            max = Math.max(i, max);
        }
        return max;
    }

    /**
     * 二维dp（0-1背包问题）
     * 这个题最重要的是找到物品 和 背包容量：
     * strs可供选择的物品
     * 背包容量就是m和n，要都满足
     * 对于每一个物品即每一个字符串，统计它们的1的个数和0的个数
     * 然后判断物品能否放进背包中，即物品的大小是否小于背包的容量，即1的个数是否小于m和0的个数是否小于n
     * 对于每一个物品，它都有两种选择：放入背包和不放入背包
     * 如果不放入背包，那么当前背包重量就是dp[i][j]
     * 如果放入背包，那么当前背包重量就是1 + dp[i-0数量][j-1数量]
     * 动态转移方程
     * for(0..strs.size)
     *   for(m...0)
     *    for(n...0)
     *       dp[i][j] = max(dp[i][j], dp[i-0数量][j-1数量]+1)//dp[i][j]用i个0和j个1能够拼出存在于数组中的字符串的最大数量
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        //保存每个位串中1的个数
        Map<String, Integer> map = new HashMap<>(strs.length);
        for(String str : strs){
            map.put(str, bitCount(str));
        }
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int oneCount = map.get(str);//1的个数
            int zoreCount = str.length() - oneCount;//0的个数
            for(int i = m; i >= zoreCount; i--){
                for(int j = n; j >= oneCount; j--){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zoreCount][j - oneCount]);
                }
            }
        }
        return dp[m][n];
    }


    private int bitCount(String num){
        int count = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
