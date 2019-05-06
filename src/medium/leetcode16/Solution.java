package medium.leetcode16;

import java.util.Arrays;

/**
 * 最接近的三数之和:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Solution {

    /**
     * 先排序，然后把三个数相加转换为两个数相加，然后用双指针遍历：O(n^2)
     */
    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        int ret = -1;
        Arrays.sort(nums);//先排序
        for(int i = 0; i < nums.length - 2; i++){
            //把三个数相加转换为两个数相加，然后用双指针遍历
            int j = i + 1;
            int t = nums.length - 1;
            while (j < t){
                int sum = nums[i] + nums[j] + nums[t];
                int d = Math.abs(sum - target);
                if(d < close) {
                    close = d;
                    ret = sum;
                }
                if(sum < target){//j往右移动，增大sum的值，使之接近target
                    j++;
                }else if(sum > target){//t往左移动，减少sum的值，使之接近target
                    t--;
                }else {
                    return target;
                }

            }
        }
        return ret;
    }

}
