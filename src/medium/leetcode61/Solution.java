package medium.leetcode61;

import common.node.ListNode;

/**
 * 旋转链表:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 */
public class Solution {

    /**
     * O(n):
     * 找到那个旋转点: rotate = len - k % len
     * 比如:
     *      1->2->3->4->5->NULL, k = 2
     * 我们要找到3这个值,用一个cur记录遍历过的节点，当 cur == rotate 时，就等于找到3这个断点了
     * 只要把它下一位为空,将5连接到1上面就行：4->5->1->2->3->NULL，然后返回指向4的指针
     * 我们还要避免回到起始点的情况，如k = 5，这时不用断点，直接返回头部指针
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p1 = head.next;
        int len = 2;
        while (p1.next != null){
            p1 = p1.next;
            len++;
        }
        int rotate = len - k % len;//找断开链表的位置
        if(rotate == len) return head;//回到起始点，不用旋转，直接返回head
        int cur = 1;
        p1 = head;
        ListNode p2 = null, ret = head;
        //下面找断点，并旋转链表
        while (p1 != null){
            if(cur == rotate){
                ret = p1.next;
                p2 = ret;
                while (p2.next != null) p2 = p2.next;
                p2.next = head;
                p1.next = null;
                break;
            }
            p1 = p1.next;
            cur++;
        }
        return ret;
    }
}
