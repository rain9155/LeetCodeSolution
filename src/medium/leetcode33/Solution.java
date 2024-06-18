package medium.leetcode33;

/**
 * 搜索旋转排序数组:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转，例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class Solution {

    /**
     * 改造二分查找法：O（logn）
     * 每次把nums从中间一分为2，那么这个时候，一部分是有序的，一部分是无序的
     * 如果target刚好中间的元素，直接返回
     * 如果前半部分是有序部分，就看target是否在有序部分中，如果在就从有序部分中找，如果不在就从无序部分中再次一分为二，再看target是否在有序部分中
     * 如果前半部分是无序部分，那么后半部分一定是有序部分，就看target是否在有序部分中，如果在就从有序部分中找，如果不在就从无序部分中再次一分为二，再看target是否在有序部分中
     * 就这样不断的一分为二，直到target被分到有序部分中，在有序部分中用二分查找，如果找不到了就返回-1
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    
    private int binarySearch(int[] nums, int target, int start, int end){
        if(start > end) return -1;
        int middle = (start + end) / 2;//把nums从中间一分为2
        if(nums[middle] == target) return middle;
        if(nums[start] <= nums[middle]){ //如果前半部分是有序部分
            if(target >= nums[start] && target < nums[middle]){
                //如果target在有序部分，使用二分查找法
                return binarySearch(nums, target, start, middle - 1);
            }else {
                //target在无序部分
                return binarySearch(nums, target, middle + 1, end);
            }
        }else {//如果前半部分不是有序部分，则后半部分一定是有序的
            if(target > nums[middle] && target <= nums[end]){
                //如果target在有序部分，使用二分查找法
                return binarySearch(nums, target, middle + 1, end);
            }else {
                //target在无序部分
                return binarySearch(nums, target, start, middle - 1);
            }
        }
    }

    /**
     * 改造二分查找法的迭代实现：
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[left]){
                if((target >= nums[left]) && (target < nums[mid])){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if((target > nums[mid]) && (target <= nums[right])){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
