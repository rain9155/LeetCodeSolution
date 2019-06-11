package medium.leetcode77;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution {

    /**
     * 回溯法
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n < 0 || k < 0) return ret;
        combine(ret, 1, new ArrayList<>(k), n, k);
        return ret;
    }

    private void combine(List<List<Integer>> ret, int start, List<Integer> cur, int n, int k){
        if(cur.size() == k){
            ret.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            cur.add(i);
            combine(ret, i + 1, cur, n, k);
            cur.remove((Integer) i);
        }
    }

}
