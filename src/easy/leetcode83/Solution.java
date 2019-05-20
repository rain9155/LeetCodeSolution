package easy.leetcode83;

import common.List;
import common.struction.ListNode;

/**
 * 删除排序链表中的重复元素:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 */
public class Solution {

    /**
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

}
