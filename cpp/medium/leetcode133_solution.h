#pragma once
#include <vector>
#include <unordered_map>

/**
 * 克隆图:
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）
 * 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）
 * 
 * 示例 1：
 * 1 ---- 2
 * |      |
 * |      |
 * 3 ---- 4
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 
 * 
 * 示例 2:
 * 1
 * 输入：adjList = [[]]
 * 输出：[[]]
 * 解释：输入包含一个空列表，该图仅仅只有一个值为 1 的节点，它没有任何邻居
 * 
 * 示例 3:
 * 输入：adjList = []
 * 输出：[]
 * 解释：这个图是空的，它不含任何节点
 * 
 * 提示：
 * 这张图中的节点数在 [0, 100] 之间
 * 1 <= Node.val <= 100
 * 每个节点值 Node.val 都是唯一的，
 * 图中没有重复的边，也没有自环
 * 图是连通图，你可以从给定节点访问到所有节点
 */
namespace Leetcode133
{
    class Node
    {
    public:
        int val;
        std::vector<Node*> neighbors;
        Node()
        {
            val = 0;
            neighbors = std::vector<Node*>();
        }
        Node(int _val) {
            val = _val;
            neighbors = std::vector<Node*>();
        }
        Node(int _val, std::vector<Node*> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    class Solution
    {
    public:
        /**
         * dfs + Map:
         * 图的遍历，用一个map保存遍历过的结点，key是旧结点，value是克隆结点
         * 1、每遍历到一个节点时，就创建这个节点的副本，把值复制，然后遍历这个节点的邻居节点，递归复制每个邻居节点，最后返回这个节点的副本
         * 2、在递归的时候，把已经复制过的节点缓存到map中，每次先检查map，如果当前节点已经复制过，就直接从map中返回当前节点的副本
         */
        Node* cloneGraph(Node* node)
        {
            std::unordered_map<Node*, Node*> map;
            return cloneGraph(node, map);
        }

        Node* cloneGraph(Node* node, std::unordered_map<Node*, Node*>& map)
        {
            if(node == nullptr)
            {
                return nullptr;
            }
            if(map.find(node) != map.end())
            {
                return map[node];
            }
            Node* clone = new Node(node->val);
            map[node] = clone;
            for(Node* neighbor : node->neighbors)
            {
                clone->neighbors.emplace_back(cloneGraph(neighbor));
            }
            return clone;
        }
    };
}