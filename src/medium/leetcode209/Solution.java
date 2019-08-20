package medium.leetcode209;

/**
 * 长度最小的子数组:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Solution {

    /**
     * O(n):
     * 双指针：
     * 1、使用两个指针，left指向子数组的左边界，right指向子数组的右边界，初始化left = right == 0
     * 2、用sum记录子数组的所有元素之和，小于s时，就移动right；否则sum就先减去left指向的元素，再移动left
     * 3、重复 2 直到right到达数组的边界，跳出循环后，判断minLen是否等于初始值MAX_VALUE，如果是表示整个数组之和都小于s，否则返回minLen
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(s <= 0 || nums.length == 0) return 0;
        int left = 0, right = 0;//初始化滑动窗口的左右边界
        int sum = 0, minLen = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            if(sum >= s){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
                sum -= nums[right];
            }else {
                right++;
            }

        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
