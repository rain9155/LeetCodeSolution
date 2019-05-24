package medium.leetcode34;

/**
 * 在排序数组中查找元素的第一个和最后一个位置:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution {

    /**
     * O(logn)
     * 改造的二分查找法：
     * 使用二分查找法，如果找到了，就从找到的位置开始向前循环，找target的出现第一个位置，然后从找到的位置开始向后循环，找target出现的最后一个位置，如果找不到返回{-1， -1}
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums == null || nums.length == 0) return ret;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int middle = (start + end) / 2;
            if (nums[middle] == target){
                int p1 = middle;
                int p2 = middle;
                while (p1 >= 0 && nums[p1] == target) p1--;
                p1++;
                while (p2 < nums.length && nums[p2] == target) p2++;
                p2--;
                ret = new int[]{p1, p2};
                return ret;
            }else if(target < nums[middle]){
                end = middle - 1;
            }else {
                start = middle + 1;
            }

        }
        return ret;
    }

}
