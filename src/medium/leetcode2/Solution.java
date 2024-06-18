package medium.leetcode2;

import common.node.ListNode;

/**
 * 两数相加:
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例1:
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 示例2:
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 示例3:
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class Solution {

    /**
     * O(n)
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加
     * 同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加, 同时更新当前位置的进位值
     * 如果两个链表全部遍历完毕后，进位值不为0，则在新链表的尾部添加一个新节点值为进位值
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;
        int carry = 0;//进位值
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = num1 + num2 + carry;
            int num = sum % 10;
            carry = sum / 10;

            cur.next = new ListNode(num);
            cur = cur.next;
            
            if(l1 != null) {
                l1 = l1.next;
            }
            
            if(l2 != null) {
                l2 = l2.next;
            }

        }
        if(carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dumy.next;
    }
}
