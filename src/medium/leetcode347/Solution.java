package medium.leetcode347;

import java.util.*;
import java.util.function.Function;

/**
 * 前 K 个高频元素:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/leetcode-di-347-hao-wen-ti-qian-k-ge-gao-pin-yuan-/
     * O(n)
     * 桶排序：
     * 1、遍历第一遍，用map记录下每个num出现的次数
     * 2、遍历第二遍，以num出现的次数作为索引，把num放在数组的相应索引处，这样在数组中，越往后的num出现的次数越高
     * 3、遍历第三遍，从数组后面遍历，找到k个数即为前 K 个高频元素
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>(k);
        if(nums == null || nums.length < k) return ret;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] lists = new ArrayList[nums.length + 1];
        for(int num : map.keySet()){
            int count = map.get(num);
            if(lists[count] == null){
                lists[count] = new ArrayList<>();
            }
            lists[count].add(num);
        }
        int len = lists.length;
        int i = len - 1;
        while (i >= 0 && k != 0){
            if(lists[i] != null){
                int size = lists[i].size();
                ret.addAll(lists[i]);
                k -= size;
            }
            i--;
        }
        return ret;
    }

}
