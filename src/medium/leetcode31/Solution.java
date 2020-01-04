package medium.leetcode31;

import common.Sorts;
import common.Utils;

import java.util.Arrays;

/**
 * 下一个排列:
 * 现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {

    /**
     * O(n)
     * 字典序算法：
     * 从右往左扫描nums，找出第一个a[i] < a[i + 1]的i位置, 没有找到则结束，该nums没有下一个排序
     * 若找到，则再次从右往左扫描nums，找出第一个a[j] > a[i], 然后交换a[i]与a[j], 然后把num[i + 1, n]升序
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while (i >= 0){
            if(nums[i] < nums[i + 1]){
                int j = nums.length - 1;
                int temp = nums[i];
                while (j > i && nums[j] <= nums[i]){
                    j--;
                }
                nums[i] = nums[j];
                nums[j] = temp;
                Sorts.bubbleSort(nums, i + 1);
                break;
            }
            i--;
        }
        if(i < 0) Sorts.bubbleSort(nums, 0);
    }



}
