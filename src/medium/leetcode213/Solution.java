package medium.leetcode213;

/**
 * 打家劫舍 II:
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class Solution {

    /**
     * 动态规划：
     * 参考198题，本题和198题不同的是房间是围起来的
     * 所以只要把第一间房间和最后一间房间分别去掉
     * 然后分别对[1, len]和[0, len - 1]的房间做动态规划，取最大值即可
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(
                rob(nums, 1, nums.length - 1),
                rob(nums, 0, nums.length - 2)
        );
    }

    private int rob(int[] nums, int start, int end){
        int pre = 0;
        int cur = nums[start];
        for(int i = start + 1; i <= end; i++){
            int temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

}
