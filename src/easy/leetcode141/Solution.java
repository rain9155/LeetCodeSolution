package easy.leetcode141;

import common.struction.ListNode;

/**
 * 环形链表:
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class Solution {


    //使用O(n)的空间，使用哈希表
    //在遍历链表时记录节点的引用，如果在哈希表中有相同的引用，就说明存在环

    /**
     * 快慢指针：
     * 设置两个指针，一个每次走一步的慢指针和一个每次走两步的快指针。
     * 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环
     * 如果含有环，快指针会超慢指针一圈，和慢指针相遇，说明链表含有环。
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null){
            p2 = p2.next.next;
            p1 = p1.next;
            if(p1 == p2) return true;
        }
        return false;
    }

}
