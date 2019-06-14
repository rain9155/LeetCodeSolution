package medium.leetcode86;

import common.List;
import common.struction.ListNode;

/**
 * 分隔链表:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution {

    /**
     * 双指针：
     * 用指针p1来追踪所有元素都小于x的链表，用指针p2追踪所有元素所有元素都大于等于x的链表
     * 然后用指针p0遍历原链表，把符合条件的x分别插入到p1和p2追踪的链表中
     * 最后合并p1和p2链表
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode head1 = new ListNode(0);//所有元素都小于x的链表
        ListNode head2 = new ListNode(0);//所有元素都大于等于x的链表
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode p0 = head;
        //遍历原链表，小于x的元素插入head1链表中，大于等于x的元素插入head2链表中
        while (p0 != null){
            if(p0.val < x){
                p1.next = p0;
                p1 = p1.next;
            }else {
                p2.next = p0;
                p2 = p2.next;
            }
            p0 = p0.next;
        }
        p2.next = null;
        //合并head1、head2两个链表
        p1.next = head2.next;
        return head1.next;
    }

}
