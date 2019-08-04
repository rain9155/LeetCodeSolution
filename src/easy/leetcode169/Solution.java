package easy.leetcode169;

import java.util.Arrays;

/**
 * 求众数:
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution {

    /**
     * O（nlogn）
     * 先排序，然后返回数组中间那个数
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * O（n）
     * Boyer-Moore 投票算法:
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int num = 0;
        for(int n : nums){
            if(count == 0) num = n;
            count += num == n ? 1 : -1;
        }
        return num;
    }

}
