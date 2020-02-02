package medium.leetcode143;

import common.node.ListNode;

/**
 * 重排链表:
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Solution {

    /**
     * 快慢指针：
     * 使用两个指针，p1指向链表的头部，p2指向链表的尾部
     * 1、然后把p2的next指向p1的next，把p1的next指向p2，这样就完成了一遍反转
     * 2、然后p1指向p2的next，作为新的头部，p2从p1开始再次找到新的尾部，然后重复1
     */
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode p1 = head, p2 = head, preP2 = null;
        while (p1 != null && p1.next != null){
            while (p2 != null && p2.next != null){
                preP2 = p2;
                p2 = p2.next;
            }
            preP2.next = null;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
        }
    }

}
