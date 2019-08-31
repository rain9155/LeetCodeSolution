package easy.leetcode217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素:
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Solution {

    /**
     * 哈希表：
     * 使用一个集合保存已经遍历过的元素
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num : nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    /**
     * 排序：
     * 先使用排序预处理，再遍历数组，看相邻元素是否重复
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

}
