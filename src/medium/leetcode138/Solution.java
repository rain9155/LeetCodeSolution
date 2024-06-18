package medium.leetcode138;

import java.util.HashMap;
import java.util.Map;

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
public class Solution {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val) {
            val = _val;
            next = null;
            random = null;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    /**
     * dfs + Map:
     * 1、首先按照普通的链表的拷贝写法，递归复制它的next节点，一直走到链表的尽头，在递归的过程中把已经复制过的节点放入map缓存
     * 2、然后递归返回，复制它的random节点，由于在1中链表的所有节点已经被复制并且缓存起来了，所以random指向的节点直接从map中取就行
     */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = copyRandomList(head.next);
        clone.random = copyRandomList(head.random);
        return clone;
    }

    /**
     * 原地算法：
     * 把复制链表的过程分为3个步骤：
     * 1、首先把链表中的每个节点复制，并让每个原始节点的next指针指向复制节点
     * 2、然后把每个复制节点的random指向原始节点的random节点的next节点(因为random节点的next节点就是它的复制节点)
     * 3、最后把奇数下标和偶数下标的节点分别串联成两个链表，奇数下标的链表就是原始链表，偶数下标的链表就是复制后的链表
     */
    public Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }
        copyNextNode(head);
        copyRandomNode(head);
        return disConnect(head);
    }

    /**
     * 把链表的每个节点复制，然后把复制节点放在每个节点的next位置
     */
    private void copyNextNode(Node head){
        Node p = head;
        while(p != null){
            Node clone = new Node(p.val);
            clone.next = p.next;
            p.next = clone;
            p = clone.next;
        }
    }

    /**
     * 把每个复制节点的random指针指向原始节点的random节点的next节点
     */
    private void copyRandomNode(Node head){
        Node p = head;
        while(p != null){
            Node clone = p.next;
            if(p.random != null){
                clone.random = p.random.next;
            }
            p = clone.next;
        }
    }

    /**
     * 分别把奇数下标和偶数下标的节点串联成两个链表，然后返回偶数下标链表的头节点
     */
    private Node disConnect(Node head){
        Node p1 = head;
        Node p2 = head.next;
        Node newHead = p2;
        while(p1 != null && p2 != null){
            p1.next = p2.next;
            p1 = p1.next;
            if(p1 != null){
                p2.next = p1.next;
                p2 = p2.next;
            }
        }
        return newHead;
    }

}
