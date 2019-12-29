package easy.leetcode350;

import java.util.*;

/**
 * 两个数组的交集 II:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Solution {

    /**
     * 哈希表：
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        if(nums2.length > nums1.length){
            int[] temp = nums1;
            nums1  = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map1.getOrDefault(num, 0) > 0 && map1.containsKey(num)){
                list.add(num);
                map1.put(num, map1.getOrDefault(num, 0) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for(int i= 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * 排序：
     * 1、首先把两个数组排序，然后初始化3个指针p1、p2、p3，p1指向nums1，p2指向nums2，p3指向输出数组ret
     * 2、然后遍历两个数组，如果遇到相等的元素，就把元素复制到ret中，同时移动指针到下一位
     * 3、如果遇到不相等的元素，哪边元素小，哪边指针移动
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] ret = new int[len];
        int p1 = 0, p2 = 0, p3 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                ret[p3] = nums2[p2];
                p1++;
                p2++;
                p3++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        return ret;
    }

}
