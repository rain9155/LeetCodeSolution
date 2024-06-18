package easy.leetcode198;

/**
 * 打家劫舍:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Solution {

    /**
     * 动态规划：
     * 如果只有一间房间，则最高金额 = nums[0];
     * 如果只有两间房间，则最高金额 = Math.max(nums[0], nums[1]);
     * 如果有三间房间，则最高金额 = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
     *                  抢第三个房子，将数额与第一个房子相加。
     *                  不抢第三个房子，保持现有最大数额。
     * 得出状态转移公式：dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i == 1){
                dp[i] = Math.max(dp[i - 1], nums[i]);
            }else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 动态规划2:
     * 得出状态转移公式：dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
     */
    public int rob2(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }

    /**
     * 动态规划3：
     * 只需要dp[i - 1] 和dp[i - 2]就可以推出下一个
     */
    public int rob3(int[] nums) {
        if(nums.length == 0) return 0;
        int prepre = 0;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            int cur = Math.max(nums[i] + prepre, pre);
            prepre = pre;
            pre = cur;
        }
        return pre;
    }

}
