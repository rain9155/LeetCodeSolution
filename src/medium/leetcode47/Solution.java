package medium.leetcode47;

import common.Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II：
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Solution {

    /**
     * 回溯法：
     * 先把nums排序
     * 在向深度递归的过程中，用一个visited数组记录下已经遍历过的nums中的元素，记为true，当递归返回时，把它重置为false，表示没有被遍历过
     * 如果这个元素在visited中为true，说明它到目前的递归深度中已经被遍历过了，就 if(visited[i]) continue;跳过
     * 所以假如nums中没有重复元素的话，当find函数递归到最深处时，会找到一个没有重复元素的全排列
     * 假如nums中有重复的元素的话，就if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue; 去重，表示如果当前元素等于前面元素并且前面的元素已经访问过了，就不再访问当前元素，跳过
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        Arrays.sort(nums);
        find(ret, new ArrayList<>(), nums, new boolean[nums.length]);
        return ret;
    }

    private void find(List<List<Integer>> ret, List<Integer> tempList, int[] nums, boolean[] visited){
        if(tempList.size() == nums.length){
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;//跳过tempList中已经有的元素
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;//跳过nums中已经遍历过的元素
            visited[i] = true;
            tempList.add(nums[i]);
            find(ret, tempList, nums, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
