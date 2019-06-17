package medium.leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {

    /**
     * 在78题的基础上增加去重步骤
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        if(nums == null || nums.length == 0) return ret;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            List<List<Integer>> temp = new ArrayList<>(ret);
            for(List<Integer> list : temp){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                //去重
                if(temp.contains(newList)) continue;
                ret.add(newList);
            }
        }
        return ret;
    }

    /**
     * 回溯法加去重
     */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ret, new ArrayList<>(), nums,  0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> tempList, int[] nums, int start){
        ret.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i] != nums[i - 1]){
                tempList.add(nums[i]);
                dfs(ret, tempList, nums, i + 1);
                tempList.remove((Integer) nums[i]);
            }
        }
    }

}
