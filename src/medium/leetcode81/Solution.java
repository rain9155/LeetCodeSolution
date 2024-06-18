package medium.leetcode81;

/**
 * 搜索旋转排序数组 II:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转，例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2]。
 * 编写一个函数来判断给定的目标值是否存在于数组中，若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 
 * 示例 2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 
 * 进阶:
 * 这是 (33:搜索旋转排序数组) 的延伸题目，本题中的nums可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class Solution {

    /**
     * 参考33题，改造的二分查找法的迭代实现：
     */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[start] && nums[mid] == nums[end]){//极端情况，头尾和中间都相等，让start和end同时移动，直到打破相等的情况, 让一边出现有序
                start++;
                end--;
            }else if(nums[mid] < nums[start]){//旋转点在mid的左边
                //mid的右边肯定是有序的
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }else {////旋转点在mid的右边或等于mid
                //mid的左边肯定是有序的
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

}
