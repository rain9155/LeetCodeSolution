package medium.leetcode377;

import java.util.Arrays;

/**
 * 组合总和 Ⅳ:
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 *
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * 进阶：
 * 如果给定的数组中含有负数会怎么样？
 * 问题会产生什么变化？
 * 我们需要在题目中添加什么限制来允许负数的出现？
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
     * 动态规划：
     * 例如，nums = [1, 2, 3], target = 4
     * 4 = 1 + 3, 求target为3的组合个数
     * 4 = 2 + 2，求为target为2的组合个数
     * 4 = 3 + 1，求为target为1的组合个数
     * 所以4的组合个数为target为3的组合个数 + target为2的组合个数 + target为1的组合个数
     * 对于target为3、2、1同理
     */
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return combinationSum4(nums, cache, target);
    }

    private int combinationSum4(int[] nums, int[] cache, int target){
        if(target < 0) return 0;
        if(0 == target) return 1;
        if(cache[target] != -1) return cache[target];
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            ret += combinationSum4(nums, cache,  target - num);
        }
        return cache[target] = ret;
    }


    public int combinationSum42(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;//nums中组合为0的个数为1个
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];

    }

}
