package medium.leetcode46;

import common.Sorts;

import java.util.*;

/**
 * 全排列:
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例 1:
 * 输入: [1,2,3]
 * 输出:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Solution<T> {


    /**
     * 回溯法：
     * 生成所有可能的全排列，不满足条件的continue
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        backtrack(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(tempList.contains(nums[i])) continue;//跳过tempList中已经有的元素
            tempList.add(nums[i]);
            backtrack(ret, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 回溯法2:
     * 全排列的所有可能为n!，n为数组的长度
     * 1、把nums的第一位和后面的任一位交换，直到和后面的所有元素都交换过
     * 2、重复1步骤(n-1次)
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack2(nums, 0, ret);
        return ret;
    }

    private void backtrack2(int[] nums, int start, List<List<Integer>> ret){
        if(start >= nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
            ret.add(list);
            return;
        }
        for(int i = start; i < nums.length; i++){
            Sorts.swap(nums, start, i);
            backtrack2(nums, start + 1, ret);
            Sorts.swap(nums, start, i);
        }
    }

}
