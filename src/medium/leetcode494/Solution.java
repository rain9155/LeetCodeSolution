package medium.leetcode494;

/**
 * 目标和:
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 注意:
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 */
public class Solution {

    private int count;

    /**
     * 枚举出所有可能：
     */
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        sum(nums, S, 0, 0);
        return count;
    }

    private void sum(int[] nums, int target, int index, int sum){
        if(index >= nums.length){
            if(sum == target){
                count++;
            }
            return;
        }
        sum(nums, target, index + 1, sum + nums[index]);
        sum(nums, target, index + 1, sum - nums[index]);
    }

    /**
     * 动态规划：
     * 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3，这里正子集P = [1, 3, 5]和负子集N = [2, 4]，
     * 于是有：
     * sum(P) - sum(N) = S =》
     * sum(P) + sum(N) + sum(P) - sum(N) = S + sum(P) + sum(N) =》
     * 2 * sum(P) = S + sum(nums) =》（这里证明S + sum(nums)必须是偶数）
     * sum(P) = (S + sum(nums)) / 2
     * 所以原来的问题转化为nums有多少个子集P，使得sum(P) = (S + sum(nums)) / 2，我们就找出P的个数，这里的(S + sum(nums)) / 2可以理解为背包的容量
     */
    public int findTargetSumWays2(int[] nums, int S) {
        if(nums.length == 0) return 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(((sum + S) & 1) != 0 || sum < S){//sum不是偶数，不存在子集P，返回0
            return 0;
        }
        //不是偶数，使用动态规划，参考01背包问题
        int target = (sum + S) / 2;
        //dp[i]表示在nums中有多少个子集P使得sum(P) = i
        int[] dp = new int[target + 1];
        //i=0时，就是说从nums中取数相加和为0时有几种取法，只有一种即一个数也不取，所以dp[0]=1
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }


}
