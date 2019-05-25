package medium.leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Solution {

    /**
     * 回溯法：
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ret,  new ArrayList<>(), candidates,  target, 0);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tempList, int[] nums, int remain, int start){
        if(remain < 0) return;
        if(remain == 0){
            ret.add(new ArrayList<>(tempList));//深拷贝，避免后续递归修改ret里面的结果
        }
        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i] != nums[i - 1]){//剔除重复数据
                tempList.add(nums[i]);
                backtrack(ret, tempList, nums, remain - nums[i], i + 1);//这里传i + 1表示不重复使用这个数字
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
