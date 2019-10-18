package medium.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums == null || nums.length < 2) return ret;
        List<Integer>[] dp = new ArrayList[nums.length];
        Arrays.fill(dp, new ArrayList<>());
        Arrays.sort(nums);
        dp[0].add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                List<Integer> list = dp[j];
                if(!list.isEmpty()){
                    int num = list.get(list.size() - 1);
                    if(nums[i] % num == 0){
                        dp[j].add(nums[i]);
                    }
                }else {
                    dp[j].add(nums[j]);
                }
            }
        }
    }

}
