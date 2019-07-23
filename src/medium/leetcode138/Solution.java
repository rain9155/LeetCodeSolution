package medium.leetcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表:
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 */
public class Solution {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    /**
     * 回溯 + Map:
     * 假设这个链表没有random指针，那么它就是一个普通的链表，这时我们就可以按照普通的写法把链表拷贝出来
     * 但是本题是有random指针，而就是说，random指针可以指向任意结点，所以我们要用一个map保存已经遍历过的node结点，防止重复创建
     * 所以我们先从按照普通的链表的拷贝写法，跟着它的next走到尽头，把链表的所有结点先拷贝，并放入map中，然后回溯，拷贝random指向的结点，如果map中有，直接返回就行
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node node = new Node(head.val, null, null);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

}
