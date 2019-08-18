package medium.leetcode189;

/**
 * 旋转数组：
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Solution {

    /**
     * O(n)
     * 使用额外的空间：
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 i 的我们把它放到 (i+k) % 数组长度 的位置，
     * 然后把新的数组拷贝到原数组中。
     */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int[] newNums = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }

        for(int i = 0 ; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length  - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        if(start < 0 || end >= nums.length) return;
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}