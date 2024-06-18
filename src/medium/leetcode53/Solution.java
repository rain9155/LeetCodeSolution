package medium.leetcode53;

/**
 * 最大子数组:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例 1:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * 
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class Solution {


    /**
     * 暴力法：O(n^2)
     * 双层循环遍历找最大和
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            for(int j = i; j < nums.length; j++){
                if(j == i){
                    temp = nums[j];
                }else {
                    temp += nums[j];

                }
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划：O(n)
     * dp[i]表示，到i为止的连续子序列的最大和
     * 每遍历到数组的一个元素时，取这个元素和这个元素加上前一个连续和的最大值为当前dp[i]的值
     * 状态转移公式：dp[i] = Math.max(nums[i], nums[i] + dp[i - 1])
     * 初始条件：dp[0] = nums[i], 当nums只有一个元素时，这个元素就是连续子序列的最大值
     */
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];//最大值
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 优化的动态规划：
     * 因为当前状态只跟前一个状态有关，所以只用一个变量thisSum保存到当前i的连续子序列的最大和就行，降低了空间复杂度
     */
    public int maxSubArray3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;//子序列的最大值
        int thisSum = 0;//当前的最大值
        for(int i = 0; i < nums.length; i++){
            thisSum = Math.max(nums[i], nums[i] + thisSum);//求当前值和加上当前值的子序列的最大值
            max = Math.max(max, thisSum);//更新子序列的最大值
        }
        return max;
    }

    //O(nlogn)
    //还可用分治法：
    //每次把数组nums一分为二，找到中间位置，所求的最大连续子串这时就在中间的两边 或 中间的左边 或 中间的右边；
    //中间左边和中间右边的和最大的子串可以递归地求得，而中间两边的和可以从中间向两边扩展累加求得；
    //返回结果就是求出来的三个和中的最大值

}
