package easy.leetcode35;

/**
 * 搜索插入位置:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class Solution {

    /**
     * O(n)
     * 暴力法（比二分查找更简单）：
     * 因为nums已经是有序的，只要从nums中从左往右找到第一个 >= target 的元素即可, 这个元素的索引就是答案
     */
    public int searchInsert1(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * O(logn)
     * 二分查找法：
     * 使用二分查找法查找第一个 >= target 的元素
     * 1、首先start = 0， end = len，终止条件(start < end)
     * 2、进行二分查找，如果找到等于 target 的元素，直接返回该元素下标；
     *                  如果找到的元素 > target，就start = mid + 1，从 mid向后移动，尽量往右靠；
     *                  如果找到的元素 < target，就end = mid，保持 mid原位，让start指针往右靠；
     * 3、最后由于start == end跳出循环，返回start或end就行
     */
    public int searchInsert2(int[] nums, int target) {
       if(nums == null || nums.length == 0) return 0;
       int start = 0;
       int end = nums.length;
       while (start < end){
           int middle = start + (end - start) / 2;
           if(target < nums[middle]){
               end = middle;
           }else if(target > nums[middle]){
               start = middle + 1;
           }else {
               return middle;
           }
       }
       return start;
    }




}
