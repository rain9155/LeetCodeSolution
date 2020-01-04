package medium.leetcode328;

import common.node.ListNode;

/**
 * 奇偶链表:
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Solution {

    /**
     * 双指针：
     * 初始化两个指针oddP和eventP，oddP指向奇数节点，eventP指向偶数节点，
     * oddP的下一个节点就是偶数节点，eventP的下一个节点就是奇数节点，
     * 所以当移动oddP时，oddP.next = eventP.next; oddP = oddP.next;
     * 当移动eventP eventP.next = oddP.next; eventP = eventP.next;
     * 最后把oddP的连上eventP的头节点即可
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode oddHead = head;
        ListNode oddP = oddHead;
        ListNode eventHead = head.next;
        ListNode eventP = eventHead;
        while (oddP != null && eventP != null){
            oddP.next = eventP.next;
            oddP = oddP.next;
            if(oddP != null){
                eventP.next = oddP.next;
                eventP = eventP.next;
            }
        }
        if(oddP == null){
            oddP = oddHead;
            while (oddP != null && oddP.next != null) oddP = oddP.next;
        }
        oddP.next = eventHead;
        return oddHead;
    }

}
