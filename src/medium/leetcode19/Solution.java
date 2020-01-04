package medium.leetcode19;

import common.node.ListNode;

/**
 * 删除链表的倒数第N个节点:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 */
public class Solution {


    /**
     * 两次遍历：
     * 第一次遍历求出链表的长度len
     * 第二次遍历删除第（len - n + 1）个节点，即倒数第n个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while (p != null){
            len++;
            p = p.next;
        }
        int d = len - n;
        if(d == 0){
            return head.next;
        }else {
            len = 0;
            ListNode delete;
            p = head;
            while (p != null){
                len++;
                if(len == d){
                    delete = p.next;
                    p.next =  delete.next;
                    delete.next = null;
                    break;
                }
                p = p.next;
            }
            return head;
        }
    }

    /**
     * 快慢指针：O(n)
     * 首先有两个指针，p1，p2
     * 一开始p1指向头部，p2比p1领先n个节点，即p2指向第n 个节点
     * 然后双指针同时移动，但p2到了尾部时，p1所指的节点就是倒数第（n + 1）个节点，此时把p1所指向的结点的下一个结点删除就行
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode p1, p2;
        p1 = p2 = dumy;

        //p2领先p1 n个结点
        while (p2.next != null && n > 0){
            p2 = p2.next;
            n--;
        }
        //p1,p2相隔n同时移动
        while (p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;

        return dumy.next;
    }

}
