package medium.leetcode75;

import common.Sorts;
import common.Utils;

import java.util.Arrays;
import java.util.Collections;

/**
 * 颜色分类:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution {

    /**
     * 快速排序：
     * 二路划分
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        Sorts.quickSort(nums);
    }

    /**
     * 参考三路划分思想：
     * 1、先从序列中选取一个数作为基数(key)；
     * 2、分区过程，将<key放到左边，>key的放在右边，=key放到中间；
     * 3、再对左右区间重复第二步，直到各区间只有一个数；
     * 返回的p数组中p[0]代表的是等于区域的左边界，p[1]代表的是等于区域的右边界
     *
     * 荷兰三色旗问题解：
     * 1、用p0指针追踪0的最右边界，用p2指针追踪2的最左边界，不用考虑1，用curr指针追踪当前遍历到的元素
     * 2、沿着数组移动 curr 指针，若nums[curr] = 0，则将其与 nums[p0]互换， cur++, p0++；
     *                           若 nums[curr] = 2 ，则与 nums[p2]互换, p2--;
     *                           若 nums[curr] = 1 ，则curr++
     *                           当curr 等于 p2时停止，这时0都被移动到头部，2都被移动到尾部，1只能在中间
     */
    public void sortColors2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while (cur < p2){
            if(nums[cur] == 0){
                Sorts.swap(nums, cur++, p0++);
            }else if(nums[cur] == 2){
                Sorts.swap(nums, cur, p2--);
            }else {
                cur++;
            }
        }
    }


}
