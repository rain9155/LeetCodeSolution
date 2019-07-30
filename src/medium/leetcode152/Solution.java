package medium.leetcode152;

/**
 * 乘积最大子序列:
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution {

    /**
     * O(n^2)
     * 暴力解法：
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            int tempMax = 1;
            for(int j = i; j < nums.length; j++){
                tempMax *= nums[j];
                max = Math.max(tempMax, max);//比较当前数和最大数哪一个数最大 和 比较连续数和最大数哪一个数最大
            }
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int tempMax = 1;
        for(int i = 0; i < nums.length; i++){
            tempMax = Math.max(nums[i], tempMax * nums[i]);
            max = Math.max(tempMax, max);//比较当前数和最大数哪一个数最大 和 比较连续数和最大数哪一个数最大
        }
        return max;
    }

}
