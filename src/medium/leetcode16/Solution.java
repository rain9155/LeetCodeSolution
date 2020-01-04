package medium.leetcode16;

import java.util.Arrays;

/**
 * 最接近的三数之和:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution {

    /**
     * 双指针：(参考15题思路)
     * 1、先排序，定义3个指针i，j，t
     * 2、每次固定nums[i]，然后用另外两个指针j, t从[i + 1, len - 1]中找两个数nums[j]和nums[t], 使得 nums[i] + nums[j] + nums[t]接近target
     */
    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        int ret = -1;
        Arrays.sort(nums);//先排序
        for(int i = 0; i < nums.length - 2; i++){
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
