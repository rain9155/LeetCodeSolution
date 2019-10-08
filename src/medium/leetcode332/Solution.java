package medium.leetcode332;

import java.util.*;
import java.util.function.Function;

/**
 * 重新安排行程:
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 *
 * 示例 1:
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/javadfsjie-fa-by-pwrliang/
     * 欧拉通路：
     * 这道题本质上是求以 "JFK" 为起点的图的欧拉通路，欧拉通路就是从一个顶点出发，沿着有向边的方向，不重复的遍历图中所有的边
     * 1、首先根据tickets构造邻接表
     * 2、然后从"JFK"开始dfs，每当遍历到一个邻接顶点时，就把这个邻接顶点到顶点的边从图中删除，即把顶点的该邻接顶点删除，这样就避免下次重复遍历这一条边
     * 3、如果遇到一个顶点，这个顶点它没有邻接顶点，即它的所有邻接边都已经遍历过了，那么这个顶点就是图的终点
     * 4、重复2、3直到所有边被遍历，最后结果就是Stack弹出元素的逆序序列
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ret = new LinkedList<>();
        if(tickets == null || tickets.size() == 0) return ret;
        //邻接表，key为图的顶点，value为小顶堆类型，保存顶点的邻接点
        Map<String, Queue<String>> map = new HashMap<>();
        //构造邻接表
        for(List<String> ticket : tickets){
           Queue<String> near = map.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>());
           near.add(ticket.get(1));
        }
        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        //dfs
        while (!stack.isEmpty()){
            String node = stack.peek();
            Queue<String> near = map.get(node);
            if(near == null || near.isEmpty()){
                ret.add(0, stack.pop());
            }else {
                String next = near.poll();
                stack.push(next);
            }
        }
        return ret;
    }

}
