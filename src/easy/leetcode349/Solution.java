package easy.leetcode349;

import java.util.*;

/**
 * 两个数组的交集:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution {

    /**
     * 哈希表：
     * 先用一个哈希表把nums1中的保存起来，然后再遍历nums2，如果哈希表中存在nums2相应元素，就输出
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        if(nums2.length > nums1.length){
            int[] temp = nums1;
            nums1  = nums2;
            nums2 = temp;
        }
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(set1.contains(num)){
                list.add(num);
            }
        }
        int[] ret = new int[list.size()];
        for(int i= 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

}
