package medium.leetcode39;

import java.util.*;

/**
 * 组合总和:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [[7],[2,2,3]]
 * 
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class Solution {


    /**
     * 回溯法：
     * 先一直递归到深处, 如果满足条件就添加进集合，如果不满足条件，就回溯到上一步
     * 在每次递归中都把(remain - nums[i]), remain表示到target的距离，如果等于0则表示，这个组合满足条件
     * 否则回溯，并把不满足条件的num从tempList中移除掉
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(candidates, target, 0, new LinkedList<>(), ret);
        return ret;
    }

    private void backtrack(int[] candidates, int target, int start, LinkedList<Integer> path, List<List<Integer>> ret) {
        if(target < 0){
            return;
        }
        if(target == 0){
            ret.add(new ArrayList<>(path));//深拷贝，避免后续递归修改ret里面的结果
            return;
        }
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, ret);//这里传i表示重复使用这个数字
            path.removeLast();
        }
    }

    /**
     * 回溯法 + 剪枝优化：
     * 如果target减去一个数得到负数，那么减去一个更大的数依然是负数，同样搜索不到结果
     * 可以对输入数组先进行排序，然后进行搜索，如果target减去当前遍历的数据为负数，那么就不进行后面更大的数的搜索
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        backtrack2(candidates, target, 0, new LinkedList<>(), ret);
        return ret;
    }

    private void backtrack2(int[] candidates, int target, int start, LinkedList<Integer> path, List<List<Integer>> ret) {
        if(target == 0){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            //剪枝
            if(target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backtrack2(candidates, target - candidates[i], i, path, ret);
            path.removeLast();
        }
    }

}
