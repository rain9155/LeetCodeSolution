package easy.leetcode189;

/**
 * 旋转数组:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
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
     * 使用额外的空间：
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 i 的我们把它放到 (i+k) % 数组长度 的位置，
     * 然后把新的数组拷贝到原数组中。
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k % len == 0) return;
        int shift = k % len;
        int[] newNums = new int[len];
        for(int i = len - shift, j = 0; i < len; i++, j++){
            newNums[j] = nums[i];
        }
        for(int i = 0, j = shift; i < len - shift; i++, j++){
            newNums[j] = nums[i];
        }
        nums = newNums.clone();
    }

    //使用双重循环：
    //1、每次先用一个temp保存nums中最后一个元素，然后nums中的元素依此向后移动一位，然后把temp放在数组的第一位
    //2、重复k次1步骤

    /**
     * 原地反转3次：
     * 第一次反转，把整个nums数组反转
     * 第二次反转，把nums中[0, k - 1]位置的元素反转
     * 第三次反转，把nums中[k, len]位置的元素反转
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k % len == 0) return;
        int shift = k % len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, shift  - 1);
        reverse(nums, shift, nums.length - 1);
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
