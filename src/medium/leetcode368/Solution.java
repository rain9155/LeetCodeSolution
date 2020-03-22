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
     * 2、准备两个数组，dp[i]代表nums中到i为止的最大子集长度，pre[i]表示nums中通过dp[j] + 1构成i成为最大子集长度的前驱元素j的位置
     * 3、遍历nums，dp[i] = max(dp[i], dp[j] + 1), 其中(0 <= j < i)，而pre[i]则等于j，当且仅当dp[j] + 1是dp[i]
     * 4、变量dp数组，找出dp[i]的最大值的位置maxIndex
     * 5、再次遍历nums，根据pre数组由maxIndex向前遍历，从nums中找到所有符合条件的元素
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        //先把nums排序
        Arrays.sort(nums);
        //dp[i]表示以nums[i]结尾的最大子集长度
        int[] dp = new int[nums.length];
        //pre[i]表示构成以nums[i]结尾为最大子集长度的前驱元素的位置
        int[] pre = new int[nums.length];
        //动态规划，
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            pre[i] = -1;
            for(int j = 0; j < i; j++){
                //状态转移方程：dp[i] = max(dp[i], dp[j] + 1)
                //同时记录由哪个元素转移而来构成最大子集长度的位置pre[i]
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        //找出构成最大子集长度的元素位置maxIndex
        int maxIndex = 0;
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            if(max < dp[i]){
                max = dp[i];
                maxIndex = i;
            }
        }
        //根据pre数组从maxIndex开始回溯找出这个最大子集中的所有元素
        for(int i = maxIndex; i >= 0; i = pre[i]){
            res.add(0, nums[i]);
        }
        return res;
    }


}
