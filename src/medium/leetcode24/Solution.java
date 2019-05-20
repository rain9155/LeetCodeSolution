package medium.leetcode24;

import common.struction.ListNode;

/**
 * 两两交换链表中的节点:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表,
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution {

    /**
     * 用三个指针p1、p2、p3
     * p1指向要交换的第一个结点，p2指向要交换的第二结点，p3指向p2的下一个结点
     * 每次交换p1，p2，并检查p3是否满足条件进行下一次交换，条件是：p3也有相邻的结点
     */
    public ListNode swapPairs(ListNode head) {

        ListNode p1, p2, p3;
        if(head == null) return null;
        if(head.next == null) return head;
        p1 = head;
        head = p1.next;
        while (p1 != null && p1.next != null){

            p2 = p1.next;
            p3 = p2.next;

            p1.next = p2.next;
            p2.next = p1;

            if(p3 != null && p3.next != null){
               p1.next = p3.next;
            }

            p1 = p3;

        }
        return head;
    }

}
