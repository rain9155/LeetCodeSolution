package medium.leetcode442;

import common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数据:
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
public class Solution {

    /**
     * 把nums中的每个数当作索引：
     * 因为题目给出1 ≤ a[i] ≤ n，所以nums中的每个num - 1都在nums的长度范围内
     * 1、我们遍历一遍数组，把数字1放在nums的0位置，把数字2放在nums的1位置，把数字num放在nums的num - 1的位置，这样做到结果是每个num都放在了自己对应的索引处
     * 2、我们再遍历一遍数组，把和相应索引处不对应的所有数字num找出来就是数组中出现2次的数字（因为数字出现了两次，所以第二个重复数字的位置被第一个重复数字占用了）
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ret.add(nums[i]);
            }
        }
        return ret;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 基于异或交换两个数字：
     * 基于异或      基于加减
     * a = a ^ b    a = a + b
     * b = a ^ b    b = a - b
     * a = a ^ b	a = a - b
     */
    private void swap2(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
