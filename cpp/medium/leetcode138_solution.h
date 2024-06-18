#pragma once
#include <map>


/**
 * 复制带随机指针的链表:
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点, 要求返回这个链表的深拷贝
 * 
 * 用一个由n个节点组成的链表来表示输入/输出中的链表，每个节点用一个[val, random_index]表示：
 * val：一个表示Node.val的整数
 * random_index：随机指针指向的节点索引(范围从0到n-1)，如果不指向任何节点，则为null 
 * 
 * 示例：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 */
namespace Leetcode138
{
    class Node 
    {
    public:
        int val;
        Node* next;
        Node* random;
        Node(int _val) {
            val = _val;
            next = nullptr;
            random = nullptr;
        }
    };

    class Solution 
    {
    public:
        /**
         * dfs + Map:
         * 1、首先按照普通的链表的拷贝写法，递归复制它的next节点，一直走到链表的尽头，在递归的过程中把已经复制过的节点放入map缓存
         * 2、然后递归返回，复制它的random节点，由于在1中链表的所有节点已经被复制并且缓存起来了，所以random指向的节点直接从map中取就行
         */
        Node* copyRandomList(Node* head)
        {
            std::map<Node*, Node*> map;
            return copyRandomList(head, map);
        }

        Node* copyRandomList(Node* head, std::map<Node*, Node*>& map)
        {
            if(head == nullptr)
            {
                return nullptr;
            }
            if(map.find(head) != map.end())
            {
                return map[head];
            }
            Node* clone = new Node(head->val);
            map.insert(std::make_pair(head, clone));
            clone->next = copyRandomList(head->next, map);
            clone->random = copyRandomList(head->random, map);
            return clone;
        }
    };
}