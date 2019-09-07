package easy.leetcode234;

import common.struction.ListNode;

/**
 * 回文链表：
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution {

    /**
     * 1、使用快慢指针找到链表中点
     * 2、从中点开始逆序后半部分
     * 3、从头部、尾部开始比较是否相同
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode p1 = head, p2 = head;
        //快慢指针找中点
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode next = null, end = null;
        //从中点开始，逆转链表
        while (p1 != null){
            next = p1.next;
            p1.next = end;
            end = p1;
            p1 = next;
        }
        //从head和pre分别开始找，即从链表的头部和尾部开始找，如果有不同的直接返回false
        while (head != null && end != null){
            if(head.val != end.val){
                return false;
            }
            head = head.next;
            end = end.next;
        }
        return true;
    }

}
