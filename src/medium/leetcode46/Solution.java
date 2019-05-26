package medium.leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列:
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {

    /**
     * 回溯法：
     * 生成所有可能的全排列，不满足条件的continue
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length == 0) return ret;
        find(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void find(List<List<Integer>> ret, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(tempList.contains(nums[i])) continue;//跳过tempList中已经有的元素
            tempList.add(nums[i]);
            find(ret, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

}
