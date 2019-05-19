package easy.leetcode53;

/**
 * 最大子序和:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {


    /**
     * O(n^2)
     * 暴力法：
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
     * 动态规划：
     * 边界：max = Integer.MIN_VALUE，thisSum = 0
     * 最优子结构：thisSum = Math.max(nums[i], nums[i] + thisSum) -》 根据当前值和加上当前值的子序列，推导出最大值
     * 状态转移公式：max = Math.max(max, thisSum) -》 和以前保存过的子序列比较，推导出最大值
     */
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;//子序列的最大值
        int thisSum = 0;//当前的最大值
        for(int i = 0; i < nums.length; i++){
            thisSum = Math.max(nums[i], nums[i] + thisSum);//求当前值和加上当前值的子序列的最大值
            max = Math.max(max, thisSum);//更新子序列的最大值
        }
        return max;
    }

}
