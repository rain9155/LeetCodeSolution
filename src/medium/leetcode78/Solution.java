package medium.leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集：
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution {

    /**
     * 生成子集：
     * 首先ret初始化一个空集，然后把nums从前往后遍历，取出每一个数num
     * 把num插入ret保存的每一个子集中，如此重复，直到nums遍历完
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null) return ret;
        ret.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];//依此得到nums中的每个元素
            List<List<Integer>> temp = new ArrayList<>(ret);
            //把num逐个插入ret保存的每个子集中
            for(List<Integer> list : temp){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                ret.add(newList);
            }
        }
        return ret;
    }

}
