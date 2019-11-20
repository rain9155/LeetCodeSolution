package medium.leetcode416;

/**
 * 分割等和子集:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Solution {

    /**
     * 参考：
     * https://www.cxyxiaowu.com/386.html
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
     * 背包问题（动态规划）：
     * 把问题抽象为，在nums数组中，是否能找到一个子集，这个子集的和为nums的和的一半
     * dp[i][j]：表示从数组的 [0, i] 这个子区间内挑选一些正整数，使得这些数的和等于 j
     * 新来一个数，例如是 nums[i]，根据这个数可能选择也可能不被选择：
     * 如果不选择 nums[i]，在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true，否则 dp[i][j] = false；
     * 如果选择 nums[i]，在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i] ，这里讨论的前提条件是 nums[i] <= j；
     * 以上二者成立一条都行。于是得到状态转移方程是： dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]], (nums[i] <= j)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        //奇数不能划分为相等的两部分
        if((sum & 1) != 0){
            return false;
        }
        //目标：从nums中找到一个子集，这个子集的和等于sum的一半
        int target = sum / 2;
        //dp[i][j]表示，从[0, i]中，有子集的和相加等于j
        boolean[][] dp = new boolean[nums.length][target + 1];
        //初始化第一行
        for(int i = 1; i < target + 1; i++){
            if(nums[0] == i){
                dp[0][i] = true;
            }
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < target + 1; j++){
                //不选择nums[i]
                dp[i][j] = dp[i - 1][j];
                //如果j >= nums[i]
                if(j >= nums[i]){
                    //尝试选择nums[i]，看是否满足dp[i - 1][j - nums[i]] = true
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    /**
     * 动态规划优化：
     * 压缩到一维空间
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        //奇数不能划分为相等的两部分
        if((sum & 1) != 0){
            return false;
        }
        //目标：从nums中找到一个子集，这个子集的和等于sum的一半
        int target = sum / 2;
        //由于二维dp，每一行都只参照了上一行的两个位置
        //所以dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]] 等价于  dp[j] = dp[j] || dp[j - nums[j]];
        boolean[] dp = new boolean[target + 1];
        //初始化
        dp[0] = true;
        for(int j = 1; j < target + 1; j++){
            if(nums[0] == j){
                dp[j] = true;
            }
        }
        for(int i = 1; i < nums.length; i++){
            //我们从后往前遍历，防止前面修改的数据影响后面的取值
            for(int j = target; j >=0 && j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
                if(dp[target]) return true;
            }
        }
        return dp[target];
    }

}
