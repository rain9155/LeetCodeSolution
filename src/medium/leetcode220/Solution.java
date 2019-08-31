package medium.leetcode220;

import java.util.*;

/**
 * 存在重复元素 III：
 *
 * 给定一个整数数组，
 * 判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false。
 */
public class Solution {

    /**
     * 二叉搜索树：
     * 初始化一颗空的二叉搜索树 tree，遍历整个数组，对于每个元素nums[i]，
     * 在 tree 上查找第一个大于等于nums[i]的节点，如果该节点 - nums[i] <= t，则返回true
     * 在 tree 上查找第一个小于等于nums[i]的节点，如果 nums[i] - 该节点 <= t, 则返回true
     * 在 tree 中插入nums[i]
     * 如果树的大小超过了k, 则移除最早加入树的那个数。
     * 遍历以后都找不到符合题意的数据对，返回 false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(k <= 0 || t < 0) return false;

        TreeSet<Integer> tree = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){

            //找nums[i]的后继节点，既第一个大于等于nums[i]的节点
            Integer ceiling = tree.ceiling(nums[i]);
            if(ceiling != null && ceiling <= t + nums[i]) return true;

            //找nums[i]的前继节点，既第一个小于等于nums[i]的节点
            Integer floor = tree.floor(nums[i]);
            if(floor != null && nums[i] <= t + floor) return true;

            tree.add(nums[i]);

            //维持tree的节点个数为k，如果大于k，就移除最旧的节点
            if(tree.size() > k) tree.remove(nums[i - k]);

        }
        return false;
    }

}
