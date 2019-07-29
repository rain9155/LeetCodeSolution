package medium.leetcode148;

import common.struction.ListNode;

/**
 * 排序链表:
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution {


    /**
     * 归并排序：
     * 1、首先使用快慢指针划分链表中点：快指针为slow，每次移动一步，快指针为fast，每次移动两步，当快指针移动到尽头时，以slow为分界线断开两个链表
     * 2、二分法左右划分链表：用1得到的两段链表，分别继续递归，递归结束条件是只剩下一个结点
     * 3、归并两个有序链表：当2的递归返回时，再重新把两段链表合并成一个链表
     */
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        //快慢指针划分链表中点
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //二分法左右划分链表
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);
        //归并两个有序链表
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while (left != null && right != null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if (left != null){
            p.next = left;
        }
        if (right != null){
            p.next = right;
        }
        return newHead.next;
    }

}
