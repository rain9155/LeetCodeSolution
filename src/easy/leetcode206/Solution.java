package easy.leetcode206;

import common.node.ListNode;

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
     * 三个指针：
     * 1、初始化3个指针p1，p2，p3，一个指向当前遍历结点的上一个结点，一个指向当前遍历结点，一个保存当前遍历结点的下一个结点
     * 2、遍历时，把当前遍历结点的next指向上一个结点，并3个指针都同时向后移动一步，直到链表尾部
     * 3、最终p2 = p3 = null， p1指向反转后的链表底部，所以返回p1
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
     * 双指针：
     * 1、初始化两个指针pre，cur，一个指向当前遍历结点的上一个结点，一个指向当前遍历结点
     * 2、遍历时，先把临时变量保存当前遍历节点的下一个节点，然后把当前遍历结点的next指向上一个结点，然后两个指针都向后移动一步，直到链表底部
     * 3、最终cur = null， pre指向反转后的链表底部，所以返回pre
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归：
     * 递归的过程就是入栈的过程，递归到底部拿到尾节点作为反转后的头节点，然后在递归返回时进行反转（head.next.next = head），最后一定记得head.next = null，避免造成循环链表
     */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
