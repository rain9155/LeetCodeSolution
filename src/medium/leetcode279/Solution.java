package medium.leetcode279;

import common.struction.Node;

import java.util.LinkedList;
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
    public int numSquares(int n) {
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

    public int numSquares2(int n) {
        if(n <= 0) return 0;
        int res = 0;
        for(int i = 1; i * i <= n; i++){
            res = numSquares2(n - i * i) + 1;

        }
        return res;
    }

}
