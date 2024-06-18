package medium.leetcode77;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合，你可以按任何顺序返回答案。
 * 
 * 示例 1:
 * 输入: n = 4, k = 2
 * 输出:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 * 
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Solution {

    /**
     * 回溯法：
     * 回溯算法是在一棵树上深度优先遍历，从树的根节点到树的叶子结点的路径为一个结果
     * 从n个数中找k个组合，转化为深度优先遍历高度为k的树，树的每层节点为[1,n]
     * 由于组合不要求数字排列的顺序性，组合中所有的数字相同即为同一组合，例如[1,2]和[2,1]表示同一个组合
     * 所以需要避免重复的组合，每一层的遍历都要跳过之前遍历过的节点
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n < 0 || k < 0) return ret;
        backtrack(ret, 1, new ArrayList<>(k), n, k);
        return ret;
    }

    public void backtrack(List<List<Integer>> ret, int start, List<Integer> path, int n, int k){
        if(path.size() == k){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            //下一轮搜索的起点要index + 1, 避免重复的组合
            backtrack(ret, i + 1, path, n, k);
            path.remove((Integer) i);
        }
    }

    /**
     * 回溯法 + 剪枝优化：
     * 如果n = 7，k = 4，从5开始搜索已经没有意义了，因即使把5选上，后面只剩下6、7，无法组合成4个数
     * 因此搜索是有边界的，边界为n - (k - path.size()) + 1
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n < 0 || k < 0) return ret;
        backtrack2(ret, 1, new ArrayList<>(k), n, k);
        return ret;
    }

    public void backtrack2(List<List<Integer>> ret, int start, List<Integer> path, int n, int k){
        if(path.size() == k){
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtrack2(ret, i + 1, path, n, k);
            path.remove((Integer) i);
        }
    }

}
