package medium.leetcode133;

import common.struction2.Node;

import java.util.*;

/**
 * 克隆图:
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（map[Node]）。
 */
public class Solution {

    Map<Node, Node> map = new HashMap<>();

    /**
     * dfs + Map:
     * 这就是一个图的遍历，用一个map保存遍历过的结点，key是旧结点，value是新结点
     * 每次递归时查找该旧结点是否创建过新结点，如果有，说明已经遍历过该旧结点，直接返回新结点就行，否则，把旧结点克隆到新结点，放入map中
     * 然后对旧结点的邻居结点进行dfs克隆，并把返回的新节点放入新结点的邻接列表
     */
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        node.neighbors.forEach(node1 -> newNode.neighbors.add(cloneGraph(node1)));
        return map.get(node);
    }

}
