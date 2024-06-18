package medium.leetcode92;

import common.node.ListNode;

/**
 * 反转链表 II:
 * 给你单链表的头指针 head 和两个整数 m 和 n，其中 1 ≤ m ≤ n ≤ 链表长度
 * 请你反转从位置 m 到位置 n 的链表节点，返回反转后的链表 
 * 
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution {

    /**
     * 三指针反转链表：
     * 首先初始化一个值为0的指针ret指向head，然后用p1找到m位置的结点，并用另外一个指针p0保存一下p1的上一个位置，如下
     *           m         n
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5
     *      p0   p1
     * 然后从m位置开始, 再用另外两个指针p2，p3，p2指向p1的下一个位置，p3指向p2的下一个位置，如下：
     *           m         n
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5
     *     p0   p1    p2   p3
     * 然后循环p2.next = p1开始指针反转链表，直到p1到达n位置，如下：
     *           m         n
     * 0 -> 1 -> 2 <- 3 <- 4    5
     *      p0             p1   p2   p3 = null
     * 最后把p0.next.next指向p2，p0.next指向p1，如下：
     *           m         n
     * 0 -> 1 -> 4 -> 3 -> 2 -> 5
     *     p0    p1             p2
     * 最后返回ret.next就行
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m < 0 || n < 0|| m >= n) return head;
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode p1 = ret;
        ListNode p0 = null;
        int i = 0;
        while (p1 != null){
            if (i == m){
                ListNode p2 = p1.next;
                while ( i != n && p2 != null){
                    ListNode p3 = p2.next;
                    p2.next = p1;
                    p1 = p2;
                    p2 = p3;
                    i++;
                }
                p0.next.next = p2;
                p0.next = p1;
                break;
            }
            p0 = p1;
            p1 = p1.next;
            i++;
        }
        return ret.next;
    }

    /**
     * 三指针反转链表：
     * 首先初始化一个值为0的虚拟头指针dumy指向head，然后用p0指向m位置上一个位置，如下
     *           m         n
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5
     *      p0
     * 然后用p1指向m位置，p2保存m位置的节点，p2就是反转链表后的尾节点，如下：
     *           m         n
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5
     *     p0   p1
     *          p2
     * 然后把p1指向的节点插入p0指向的下一个位置，直到n，如下：
     *      m              n
     * 0 -> 1 -> 4 -> 3 -> 2    5
     *      p0            p2    p1
     * 最后把把p2的下一个位置指向p1，如下：
     *      m              n
     * 0 -> 1 -> 4 -> 3 -> 2 -> 5
     *     p0             p2    p1
     * 最后返回dumy.next就行
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode p0 = dumy, p1, p2;
        for(int i = 1; i < m; i++){
            p0 = p0.next;
        }
        p1 = p0.next;
        p2 = p1;
        for(int i = m; i <= n; i++){
            ListNode next = p1.next;
            p1.next = p0.next;
            p0.next = p1;
            p1 = next;
        }
        p2.next = p1;
        return dumy.next;
    }

}
