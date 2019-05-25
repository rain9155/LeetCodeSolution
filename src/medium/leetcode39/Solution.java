package medium.leetcode39;

import java.util.*;

/**
 * 组合总和:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution {


    /**
     * 回溯法：
     * 先一直递归到深处, 如果满足条件就添加进集合，如果不满足条件，就回溯到上一步
     * 在本题里，在每次递归中都把(remain - nums[i]), remain表示到target的距离，如果等于0则表示，这个组合满足条件。否则回溯，并把不满足条件的num从tempList中移除掉
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ret;
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
            if(i == 0 || nums[i] != nums[i - 1]){//剔除重复数据
                tempList.add(nums[i]);
                backtrack(ret, tempList, nums, remain - nums[i], i);//这里传i表示重复使用这个数字
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
