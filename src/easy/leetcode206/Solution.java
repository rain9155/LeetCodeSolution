package easy.leetcode206;

import common.struction.ListNode;

/**
 * 反转链表:
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {

    /**
     * 迭代：
     * 三个指针，一个指向当前遍历结点，一个保存当前遍历结点的下一个结点，一个指向当前遍历结点的上一个结点
     * 遍历时，把当前遍历结点的next指向上一个结点，并3个指针都同时向后移动一步，直到链表尾部
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode p1, p2, p3;
        p1 = null;
        p2 = head;
        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    /**
     * 递归：
     * 递归的主要难点就是如何返回反转后链表的头结点，而我们知道递归的过程就是入栈的过程，
     * 所以我们一直把head.next入栈，直到head.next == null即到达链表尾部才返回到上一层递归，这样就拿到了反转后链表的头结点，
     * 接着我们就把head.next.next = head，即把下一个结点的指向当前结点，实现链表反转
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
