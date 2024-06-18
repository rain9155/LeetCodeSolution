package medium.leetcode918;

/**
 * 环形子数组的最大和：
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空子数组的最大可能和 。
 * 
 * 环形数组意味着数组的末端将会与开头相连呈环状，形式上，
 * nums[i] 的下一个元素是 nums[(i + 1) % n]，nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 
 * 子数组最多只能包含固定缓冲区 nums 中的每个元素一次，形式上，
 * 对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * 
 * 示例 1：
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 
 * 示例 2：
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 
 * 示例 3：
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 */
public class Solution {

    /**
     * 动态规划 + 取反：参考53题最大子数组和
     * 如果最大子数组没有跨越nums边界，那么转化为求nums中的最大子数组和，记为maxS
     * 如果最大子数组跨越nums边界，那么最大子数组和等于nums数组和减去最小子数组和，那么转化为求nums数组和和nums中的最小子数组和，记为sum(nums)和minS
     * 所以环形数组的最大子数组和为max(maxS, sum(nums)-minS)
     */
    public int maxSubarraySumCircular(int[] nums) {
        int maxS = Integer.MIN_VALUE;
        int minS = Integer.MAX_VALUE;
        int curMaxS = 0;
        int curMinS = 0;
        int sum = 0;
        for(int num : nums) {
            curMaxS = Math.max(curMaxS + num, num);
            maxS = Math.max(maxS, curMaxS);
            curMinS = Math.min(curMinS + num, num);
            minS = Math.min(minS, curMinS);
            sum += num;
        }
        //特殊情况，sum == minS表示最小子数组就是整个数组，这时sum - minS为0，表示跨越边界的最大子数组和为0
        //这时如果没有跨越边界的最大子数组和即maxS为负数，最后判断就会返回0导致返回错误，这时需要返回maxS
        if(sum == minS) {
            return maxS;
        }
        return Math.max(maxS, sum - minS);
    }
}
