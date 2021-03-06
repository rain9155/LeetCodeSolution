package easy.leetcode414;

import java.util.TreeSet;

/**
 * 第三大的数:
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class Solution {

    /**
     * 维护一个大小为3的红黑树：
     * 因为红黑树是一颗二分查找树，所以这个3个数在大小为3的红黑树中一定是从小到大排列，每当由第4个数加入时，就把第一次个数删除就行
     */
    public int thirdMax(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int n : nums){
            treeSet.add(n);
            if(treeSet.size() > 3)
                treeSet.remove(treeSet.first());
        }
        return treeSet.size() < 3 ? treeSet.last() : treeSet.first();
    }

}
