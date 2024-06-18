package medium.leetcode162;

/**
 * 寻找峰值:
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class Solution {

    /**
     * 一次遍历：O(n)
     * 遍历nums数组，只要nums[i] > nums[i + 1]，nums[i]就是峰值
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * 二分查找：O(nlogn)
     * 找到上坡的第一个拐点
     * 1、当nums[mid] < nums[mid+1], 拐点一定在mid的右边，所以l = mid + 1
     * 2、当nums[mid] >= nums[mid+1], 那么mid可能是拐点，收拢r靠近mid，所以r = mid;
     * 为什么二分查找大的那一半一定会有峰值呢？即nums[mid] < nums[mid+1]时，[mid+1,N]一定存在峰值
     * 首先已知，那么mid+2只有两种可能，一个是大于mid+1，一个是小于mid+1;
     * 小于mid+1的情况，那么mid+1就是峰值;
     * 大于mid+1的情况，继续向右推，如果一直到数组的末尾都是大于的，那么可以肯定最后一个元素是峰值,因为nums[nums.length]=负无穷
     */
    public int findPeakElement2(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

}
