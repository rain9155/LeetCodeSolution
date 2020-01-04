package easy.leetcode203;

import common.node.ListNode;

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
     * 双指针：
     * 1、添加一个虚拟头节点dummy，指向head，防止head就是要删除的节点
     * 2、初始化两个指针，一个指向当前遍历的结点head，一个指向当前遍历的结点的上一个结点preHead
     * 3、每次看head的结点值是否等于val，如果等于且不是位于链表尾部，就把head的下一个结点值覆盖head的结点值，并把head的next指向head的next的next；
     *                                如果等于且位于链表尾部，就把当前结点删除，即把 preHead.next置空
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preHead = dummy;
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
        return dummy.next;
    }

    /**
     * 单指针：
     * 1、添加一个虚拟头节点dummy，指向head
     * 2、然后判断下一个节点是否是需要删除的节点，如果是，就把当前节点指向下一个节点的下一个节点；
     *                                          如果不是，移动当前节点到下一个节点
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null){
            if(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * 使用额外空间
     * 递归（链表的后序遍历）：
     * 1、递归函数的返回是不含重复元素的链表头，当递归返回时，把当前链表节点的next指向这个链表头
     * 2、然后判断当前链表节点是否需要删除，如果需要，就返回next，如果不需要，就返回head
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode next = removeElements3(head.next, val);
        head.next = next;
        if(head.val == val){
            return next;
        }
        return head;
    }

}
