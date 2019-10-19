package medium.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 最大整除子集:
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，
 * 子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 */
public class Solution {


    /**
     * 动态规划：
     * 1、先把nums排序
     * 2、准备两个dp数组，dp[i]代表nums中到i为止的最大子集长度，dp2[i]表示nums中通过dp[j] + 1构成i成为最大子集长度的前驱元素j的位置
     * 3、dp初始化为1，dp2初始化为-1
     * 4、遍历nums，dp[i] = max(dp[i], dp[j] + 1), 其中(0 <= j < i)，而dp2[i]则等于j，当且仅当dp[j] + 1是dp[i]，表示从nums j 这个位置 +1 让i成为最大子集长度,同时记录dp[i]的最大值
     * 5、再次遍历nums，先找到等于dp[i]的最大值max的i的位置，向前遍历，然后根据dp2记录的索引位置在nums中找到所有符合条件的元素
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if(nums == null || nums.length == 0) return ret;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, -1);
        int max = Integer.MIN_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    dp2[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        for(int i = maxIndex; i >= 0; i = dp2[i]){
            ret.add(0, nums[maxIndex]);
        }
        return ret;
    }


}
