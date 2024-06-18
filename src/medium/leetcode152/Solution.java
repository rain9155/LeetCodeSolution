package medium.leetcode152;

/**
 * 乘积最大子数组:
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子数组（该序列至少包含一个数）。
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
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

    /**
     * O(n)
     * 动态规划：
     * 如果数组中负数为偶数个，那么最大乘积为整个数组的和，如果数组中负数为奇数个，那么最大乘积就要动态规划：
     * 1、设置两个max和min，遍历数组时不断更新当前最大值max和最小值min
     * 2、由于存在负数，那么会导致最大的变最小的，最小的变最大的，因此当负数出现时，把max和min进行交换后再进行1步骤
     */
    public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int max = res;//记录到目前i为止，连续子数组的最大乘积
        int min = res;//记录到目前i为止，连续子数组的最小乘积
        for(int i = 1; i < nums.length; i++){
            //当元素小于0时，会导致最大值变为最小值，最小值变为最大值
            //所以这里交换最大值和最小值，让下面的累乘满足记录最大值和最小值情况
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            //不断的更新最大值和最小值
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            //返回结果取最大值
            res = Math.max(max, res);
        }
        return res;
    }

}
