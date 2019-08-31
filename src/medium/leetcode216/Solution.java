package medium.leetcode216;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III:
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution {

    List<List<Integer>> ret = new ArrayList<>();

    /**
     * 回溯算法
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k < 0 || n < 0 || k > n) return ret;
        combinationSum(1, k, n, new ArrayList<>(), 0);
        return ret;
    }

    private void combinationSum(int start, int k, int n, List<Integer> tempList, int tempSum) {
        if(tempList.size() == k){
            if(tempSum == n)
                ret.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i <= 9; i++){
            tempList.add(i);
            tempSum += i;
            combinationSum(i + 1, k, n, tempList, tempSum);
            tempList.remove(tempList.size() - 1);
            tempSum -= i;
        }
    }
}
