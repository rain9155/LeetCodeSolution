package easy.leetcode203;

import common.struction.ListNode;

/**
 * 移除链表元素：
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {

    /**
     * 两个指针：
     * 一个指向当前遍历的结点head，一个指向当前遍历的结点的上一个结点preHead
     * 每次看head的结点值是否等于val，如果等于且不是位于链表尾部，就把head的下一个结点值覆盖head的结点值，并把head的next指向head的next的next
     *                               如果等于且位于链表尾部，就把当前结点删除，即把 preHead.next置空
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode preHead = newHead;
        while (head != null){
            if(head.val == val){
                if(head.next != null){
                    head.val = head.next.val;
                    head.next = head.next.next;
                }else {//到达链表尾部
                    preHead.next = null;
                }
            }else {
                preHead = head;
                head = head.next;
            }
        }
        return newHead.next;
    }

}
