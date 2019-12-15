package easy.leetcode21;

import common.struction.ListNode;

/**
 * 合并两个有序链表：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {


    /**
     * 不增加头结点法：
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1, p2 = l2;
        ListNode p3 = null, head = null;

        while (p1 != null && p2 != null){
            ListNode node;
            if(p1.val < p2.val){
                if(head == null){
                    head = new ListNode(p1.val);
                    p3 = head;
                }else {
                    node = new ListNode(p1.val);
                    p3.next = node;
                    p3 = p3.next;
                }
                p1 = p1.next;
            }else {
                if(head == null){
                    head = new ListNode(p2.val);
                    p3 = head;
                }else {
                    node = new ListNode(p2.val);
                    p3.next = node;
                    p3 = p3.next;
                }
                p2 = p2.next;
            }
        }
        while (p1 != null){
            ListNode node;
            if(head == null){
                head = new ListNode(p1.val);
                p3 = head;
            }else {
                node = new ListNode(p1.val);
                p3.next = node;
                p3 = p3.next;
            }
            p1 = p1.next;
        }

        while (p2 != null){
            ListNode node;
            if(head == null){
                head = new ListNode(p2.val);
                p3 = head;
            }else {
                node = new ListNode(p2.val);
                p3.next = node;
                p3 = p3.next;
            }
            p2 = p2.next;
        }

        return head;
    }

    /**
     * 改进版：
     * 额外增加一个头结点，当合并完l1和l2后，把剩余的链表的头结点直接连到后面
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(0);
        ListNode p3 = head;

        while (p1 != null && p2 != null){
            ListNode node;
            if(p1.val < p2.val){
                node = new ListNode(p1.val);
                p3.next = node;
                p3 = p3.next;
                p1 = p1.next;
            }else {
                node = new ListNode(p2.val);
                p3.next = node;
                p3 = p3.next;
                p2 = p2.next;
            }
        }
        if (p1 != null){
            p3.next = p1;
        }
        if (p2 != null){
            p3.next = p2;
        }

        return head.next;
    }


    //3、可以使用递归，写法更简洁
}
