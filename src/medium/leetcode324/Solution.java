package medium.leetcode324;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 摆动排序 II:
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 *
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class Solution {

    /**
     * O（nlogn）
     * 把数组nums分成较大一部分的数big和较小一部分数small，然后互相穿插即可，穿插的时候要降序穿插
     * 例如：[1, 5, 1, 1, 6, 4]，经过排序后为[1, 1, 1, 4, 5, 6]，
     * 分成两部分后，small = [1, 1, 1], big = [4, 5, 6],
     * 然后small和big降序穿插得到新的num = [1, 6, 1, 5, 1, 4]即为结果
     */
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int smallLen = (len % 2 == 0) ? (len / 2) : (len / 2 + 1);
        int bigLen = len / 2;
        int[] small = new int[smallLen];
        int[] big = new int[bigLen];
        //对数组排序
        Arrays.sort(nums);
        //然后把数组分为两部分：small和big，big里面的元素都比small中的元素大
        System.arraycopy(nums, 0, small, 0, smallLen);
        System.arraycopy(nums, smallLen, big, 0, bigLen);
        //然后穿插排序，注意要从small和big后面开始取元素
        for(int i = smallLen - 1, j = 0; i >= 0 && j < len; i--, j += 2){
            nums[j] = small[i];
        }
        for(int i = bigLen - 1, j = 1; i >= 0 && j < len; i--, j += 2){
            nums[j] = big[i];
        }
    }

    //O(n)算法：
    //可以采用快速排序的划分算法找到数组的中位数，这样就把数组分为3部分：
    //第一部分的数都小于中位数，第二部分的数就是中位数，第三部分的数都大于中位数
    //然后对第一部分和中位数 + 第二部分进行穿插放置

}
