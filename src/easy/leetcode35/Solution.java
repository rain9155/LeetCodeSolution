package easy.leetcode35;

/**
 * 搜索插入位置:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class Solution {


    /**
     * 先用二分查找法，如果找到，直接返回，如果找不到，就根据start和end的位置的元素大小判断target在nums中的位置
     */
    public int searchInsert(int[] nums, int target) {
       if(nums == null || nums.length == 0) return 0;
       int start = 0;
       int end = nums.length - 1;
       while (start <= end){
           int middle = (start + end) / 2;
           if(target == nums[middle]){
               return middle;
           }else if(target < nums[middle]){
               end = middle - 1;
           }else {
               start = middle + 1;
           }
       }
       if(start >= nums.length){
           return nums.length;
       }
       if(end < 0){
           return 0;
       }
       if(target > nums[start]){
           return start + 1;
       }else if(target > nums[end]){
           return end + 1;
       }else {
           return end - 1;
       }
    }


    /**
     * 比二分查找更简单，因为nums已经是有序的，只要从nums中从左往右找到第一个 >= target 的元素即可
     */
    public int searchInsert2(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}
