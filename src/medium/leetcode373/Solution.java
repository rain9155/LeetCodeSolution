package medium.leetcode373;

import java.util.*;

/**
 * 查找和最小的K对数字:
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 */
public class Solution {

    /**
     * 最小堆（当num1和num2长度很大时会OOM）：O(nmlogn)
     * 首先使用双循环从两个数组中取出所有数对，把这些数对放入最小堆中，弹出最小堆中的前k个数对
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums1.length == 0 || nums2.length == 0) {
            return ret;
        }
        PriorityQueue<int[]> priority = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                int sum1 = pair1[0] + pair1[1];
                int sum2 = pair2[0] + pair2[1];
                return sum1 - sum2;
            }
        });
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                priority.add(new int[]{nums1[i], nums2[j]});
            }
        }
        while (!priority.isEmpty() && k > 0){
            int[] nums = priority.poll();
            List<Integer> list = new ArrayList<>(2){{
                add(nums[0]);
                add(nums[1]);
            }};
            ret.add(list);
            k--;
        }
        return ret;
    }

    /**
     * 最小堆（优化版）：O(klogk)
     * 记数对[nums1[i], nums2[j]]对应的下标对为[i, j], 先把数对[nums1[i], nums2[0]]的下标对[i, 0]放入最小堆中
     * 这时堆顶的下标对为[0, 0]，其对应的数对是所有数对中和最小的, 弹出堆顶的下标对，把下标对对应的数对放入答案，再尝试把[i, j + 1]下标对放入最小堆中，直到弹出k次堆顶元素
     */
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if(nums1.length == 0 || nums2.length == 0) {
            return ret;
        }
        PriorityQueue<int[]> priority = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] indexs1, int[] indexs2) {
                int sum1 = nums1[indexs1[0]] + nums2[indexs1[1]];
                int sum2 = nums1[indexs2[0]] + nums2[indexs2[1]];
                return sum1 - sum2;
            }
        });
        for(int i = 0; i < Math.min(k, nums1.length); i++) {
            priority.add(new int[]{i, 0});
        }
        while (!priority.isEmpty() && k > 0) {
            int[] indexs = priority.poll();
            List<Integer> list = new ArrayList<>(2){{
                add(nums1[indexs[0]]);
                add(nums2[indexs[1]]);
            }};
            ret.add(list);
            if(indexs[1] + 1 < nums2.length) {
                priority.add(new int[]{indexs[0], indexs[1] + 1});
            }
        }
        return ret;
    }

}
