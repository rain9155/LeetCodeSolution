package medium.leetcode147;

import common.struction.ListNode;

/**
 * 对链表进行插入排序:
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution {

    /**
     * 双指针：
     * 1、用head指针指向已经排好序的链表元素的最后一个，用ret指针指向链表的头指针的前驱
     * 2、每次先比较head和head的后驱结点的大小，如果 head <= head后驱，head向后移动，跳过3， 进行2，否则就进入3
     * 3、每次让pre指针指向ret，把pre的后驱结点和head的后驱结点比较，如果pre < head，pre向后移动，直到找到第一个比head的后驱大的pre的后驱结点，找到后进入4
     * 4、把head的后驱结点插入到pre的后驱
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(0);
        ret.next = head;
        while (head != null && head.next != null){
            if(head.val <= head.next.val){
                head = head.next;
                continue;
            }
            ListNode pre = ret;
            while (head.next.val > pre.next.val) pre = pre.next;
            head.next = head.next.next;
            head.next.next = pre.next;
            pre.next = head.next;

        }
        return ret.next;
    }

}
