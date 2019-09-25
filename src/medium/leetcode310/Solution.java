package medium.leetcode310;

import java.util.*;

/**
 * 最小高度树:
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。
 * 图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * 示例 1:
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * 输出: [1]
 * 示例 2:
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * 输出: [3, 4]
 *
 * 说明:
 *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class Solution {

    /**
     * 超时
     * 蛮力法：
     * 1、构建图的邻接表
     * 2、遍历1~n，以每个节点作为树的根节点开始BFS,并记录每个节点的深度
     * 3、返回最小深度的那几个节点
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        //构建图的邻接表
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        boolean[] visited = new boolean[n];
        int[] depth = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        //遍历，以每个节点作为根节点开始BFS, 并记录每个节点作为树的根节点时的深度
        for(int i = 0; i < n; i++){
            int curDepth = 0;
            int len = 0;
            queue.add(i);
            while (!queue.isEmpty()){//BFS
                if(len == 0) {
                    len = queue.size();
                    curDepth++;
                }
                len--;
                int from = queue.poll();
                visited[from] = true;
                for(int j = 0; j < graph[from].size(); j++){
                    int to = graph[from].get(j);
                    if(!visited[to]){
                        queue.add(to);
                    }
                }
            }
            depth[i] = curDepth;
            Arrays.fill(visited, false);
        }
        //找出以某个节点作为树的根节点时最小深度的节点
        int min = depth[0];
        int root = 0;
        for(int i = 1; i < n; i++){
            if(depth[i] < min){
                root = i;
                min = depth[i];
            }
        }
        ret.add(root);
        for(int i = 0; i < n; i++){
            if(i == root) continue;
            if(depth[i] == min){
                ret.add(i);
            }
        }
        return ret;
    }

    /**
     * 减一法：
     * 把所有入度为1的结点从图中删除，直到图只剩下1个或2个节点
     */
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        //构建图的邻接表,并记录每个节点的入度
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
            degree[from]++;
            degree[to]++;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        //因为是无向图，所以每个节点的出度至少为1，记录每个节点的出度为1的节点
        for(int i = 0; i < n; i++){
            if(degree[i] == 1){
                queue.add(i);
            }
        }
        //把所有入度为1的结点从图中删除，直到图只剩下1个或2个节点
        while (n > 2){
            int len = queue.size();
            n -= len;
            for(int i = 0; i < len; i++){
                int from = queue.poll();
                visited[from] = true;
                for(int to : graph[from]){
                    degree[to]--;
                    if(degree[to] == 1){
                        queue.add(to);
                    }
                }
            }
        }
        //找出没有遍历的节点就是返回结果
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                ret.add(i);
            }
        }
        return ret;
    }

}
