package medium.leetcode128;
import java.util.*;

/**
 * 最长连续序列:
 * 给定一个未排序的整数数组nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Solution {

    /**
     * 时间复杂度O(nlogn)
     * 先把数组排序，然后再遍历排序后的数组记录最长连续子序列长度
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int count = 1;
        int current = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                current++;
                count = Math.max(count, current);
            } else if(nums[i] != nums[i - 1]) {
                current = 1;
            } 
        }
        return count;
    }

    /**
     * 时间复杂度O(n)
     * 先用set保存去重后的数组，然后遍历去重后的数组，通过!set.contains(num-1)判断这个元素是不是连续序列开头的元素，
     * 如果num-1不存在set中，表示这个元素num是连续序列开头的元素，然后就拿num + 1、num + 2、...去set中判断是否存在，
     * 如果存在表示num + 1、num + 2、...是以num开头的连续序列中的元素，记录连续序列长度，更新最大连续序列的长度
     */
    public int longestConsecutive2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int count = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int current = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    current++;
                    curNum++;
                }
                count = Math.max(count, current);
            }
        }
        return count;
    }

}
