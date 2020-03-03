package medium.leetcode279;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 完全平方数:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Solution {

    /**
     * 递归 + 备忘录：
     * 假设要求组成12的完全平方数，组成12的完全平方数等于组成11、8、3的完全平方数 + 1
     * 而组成11的完全平方数等于组成10、7、2的完全平方数 + 1，组成8的完全平方数等于组成7、4的的完全平方数 + 1，...
     * 依此类推,最终组成12的完全平方数的个数最少为组成11、8、3的完全平方数中的最小值 + 1
     */
    public int numSquares(int n) {
        return helper(n, new HashMap<>());
    }

    private int helper(int n, Map<Integer, Integer> cache){
        if(n <= 0){
            return 0;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int i = 1;
        int min = Integer.MAX_VALUE;
        while(i * i <= n){
            min = Math.min(min, helper(n - i * i, cache) + 1);
            i++;
        }
        cache.put(n, min);
        return min;
    }

    /**
     * 一维dp：
     * dp[i]表示组成i数字的完全平方的最少个数
     * 状态转移方程为：dp[i] = min(dp[i], dp[j - square] + 1)，其中square <= i, square = j * j, j < i
     */
    public int numSquares2(int n) {
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }

    private class Node{

        int val;
        int lever;

        public Node(int val, int lever){
            this.val = val;
            this.lever = lever;
        }

    }

    /**
     * 转换为图论：
     * 使用BFS，把1到n的数当作图中的节点
     * 1、初始化队列只有一个节点[n, 0], 表示节点值为n，在第0层
     * 2、然后每遍历到一个节点，就尝试用节点值去减1到节点值之间的完全平方数，如节点值 = 13， 尝试减去1、4、9，得到12、9、4这三个节点值又add进队列中
     * 3、重复2步骤，直到遇到某个节点值减去一个完全平方数等于后等于0的层数，然后这个层数就是完全平方数组成和为n的最少个数
     * 优化：用一个boolean数组保存已经add过的节点
     */
    public int numSquares3(int n) {
        if(n <= 0) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int i = 1;
            while (true){
                int num = node.val - i * i;
                if(num < 0) break;
                if(num == 0) return node.lever + 1;
                if(!visited[n]){
                    queue.add(new Node(num, node.lever + 1));
                    visited[n] = true;
                }
                i++;
            }
        }
        return 0;
    }

}
