package common;

import common.struction.ListNode;

/**
 * 链表
 */
public class List {

    /**
     * 给定一个数组，初始化一个链表
     * @param nums 数组
     * @return 链表的头结点
     */
    public ListNode initList(int[] nums){
        ListNode p = null, head = null;
        int len = nums.length;
        int i = 0;
        while (i < len){
            if(i == 0) {
                p = new ListNode(nums[i]);
                head = p;
                i++;
                continue;
            }
            p.next = new ListNode(nums[i]);
            p = p.next;
            i++;
        }
        return head;
    }

    /**
     * 给定链表的头结点，打印出链表
     * @param head 链表的头结点
     */
    public void printList(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.print(p.val);
            if(p.next != null) System.out.print(" -> ");
            p = p.next;
        }
        System.out.println();
    }

}
