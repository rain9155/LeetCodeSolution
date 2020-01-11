package medium.leetcode80;

import common.Utils;

/**
 * 删除排序数组中的重复项 II:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {


    /**
     * O（n）
     * 双指针遍历：
     * 1、首先定义两个指针p1、p2都指向nums的第一个元素
     * 2、p1为待插入元素的位置，移动p2，并用count记录重复元素的个数，当count <= 2 就把p2指向的元素插入p1的位置
     * 3、当p2移动到nums的尽头时，返回p1就是满足条件的长度
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        int p1 = 0;
        for(int p2 = 0; p2 < nums.length; p2++){
            if(p2 == 0 || nums[p2] == nums[p2 - 1]){
                count++;
            }else {
                count = 1;
            }
            if(count <= 2){
                nums[p1] = nums[p2];
                p1++;
            }
        }
        return p1;
    }

}
