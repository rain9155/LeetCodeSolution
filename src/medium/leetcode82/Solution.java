package medium.leetcode82;

import common.node.ListNode;

/**
 * 删除排序链表中的重复元素 II:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution {

    /**
     * O(n)
     * 快慢指针：
     * p1为慢指针，p2为快指针，如果p2遇到重复的元素，用p2跳过重复的元素，把p2和p1拼接，如果没有遇到，则p1和p2都向后移动
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode h = new ListNode(0);
        ListNode p1 = h;
        ListNode p2 = head;
        while (p2 != null){
            if(p2.next != null && p2.val == p2.next.val){
                while (p2.next != null && p2.val == p2.next.val){
                    p2 = p2.next;
                }
                p2 = p2.next;
                p1.next = p2;
            }else {
                if(p1.next == null){
                    p1 = head;
                    h.next = head;
                }else {
                    p1 = p1.next;
                }
                p2 = p2.next;
            }
        }
        return h.next;
    }

}
