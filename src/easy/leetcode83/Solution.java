package easy.leetcode83;

import common.node.ListNode;

/**
 * 删除排序链表中的重复元素:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class Solution {

    /**
     * 常规做法：
     * 遍历链表，如果下一个节点与当前节点相同，就删除下一个节点，直到下一个节点与当前节点不相同
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode next;
        while (p1 != null){
            if(p1.next != null){
                next = p1.next;
                if(p1.val == next.val){
                    p1.next = next.next;
                    next.next = null;
                }else {
                    p1 = p1.next;
                }
            }else {
                p1 = p1.next;
            }
        }
        return head;
    }

    /**
     * 递归：
     * 1、先递归到链表底部，此时只剩下一个节点，肯定不会重复，返回这个节点
     * 2、当递归返回时，比较当前节点和返回的节点的值是否重复，如果重复，丢弃当前节点，返回返回的节点，否则把返回节点连接上当前节点，返回当前节点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){//只有一个节点，肯定不会重复，返回这个节点
            return head;
        }
        ListNode next = deleteDuplicates2(head.next);
        //当递归返回时，比较当前节点head是否和下一个节点next重复
        if(head.val == next.val){//如果重复，不要head节点
            return next;
        }else {//如果不重复，连接，返回head节点
            head.next = next;
            return head;
        }
    }

}
