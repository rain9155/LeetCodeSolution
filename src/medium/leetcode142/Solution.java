package medium.leetcode142;

import common.struction.ListNode;

/**
 * 环形链表 II:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Solution {

    /**
     * 快慢指针：
     * 设置两个快慢指针p2和p1，当p2没有走到尽头时就证明有环，有环p1和p2就会在环中的某一个点相遇
     * 当相遇后，让p1回到起点，p2保持在相遇点，然后p1和p2同时移动相同的步数，当p1与p1再次相遇时，就是入环点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null){
            p2 = p2.next.next;
            p1 = p1.next;
            if(p1 == p2){//经过证明，当fast和slow相交的时，让fast回到起点，fast和slow都只走一步，然后fast和slow第一次相遇的地方就是交点
                p1 = head;
                while (p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

}
