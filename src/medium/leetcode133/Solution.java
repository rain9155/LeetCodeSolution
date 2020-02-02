package medium.leetcode133;

import java.util.*;

/**
 * 克隆图:
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（map[Node]）。
 */
public class Solution {

    class Node{
        public int val;
        public List<Node> neighbors;

        Node(int val){
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    Map<Node, Node> cache = new HashMap<>();

    /**
     * dfs + Map:
     * 图的遍历，用一个map保存遍历过的结点，key是旧结点，value是新结点
     * 1、每遍历到一个节点时，就创建这个节点的副本，把值复制，然后遍历这个节点的邻居节点，递归复制每个邻居节点，最后返回这个节点的副本
     * 2、在递归的时候，把已经复制过的节点缓存到map中，每次先检查map，如果当前节点已经复制过，就直接从map中返回当前节点的副本
     */
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        if(cache.containsKey(node)){
            return cache.get(node);
        }
        Node clone = new Node(node.val);
        cache.put(node, clone);
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

}
