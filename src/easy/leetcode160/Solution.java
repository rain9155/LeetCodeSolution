package easy.leetcode160;

import common.node.ListNode;

/**
 * 相交链表:
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Solution {

    //使用O(n)空间复杂度，使用哈希表
    //先遍历headA，遍历时用哈希表记录节点引用
    //然后遍历headB，遍历时看哈希表中是否存在相同引用，如果有，这个引用就是相交的节点

    /**
     * O(n + m):
     * 1、记录两个链表的长度，计算出两队链表长度的差值
     * 2、利用差值让长的链表先走
     * 3、经过1、2后两个链表就在同一个起点了，然后p1和p2同时向后移动，直到相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p1 = headA;
        int headALen = 0;
        while (p1 != null){
            p1 = p1.next;
            headALen++;
        }
        ListNode p2 = headB;
        int headBLen = 0;
        while (p2 != null){
            p2 = p2.next;
            headBLen++;
        }
        int d = Math.abs(headALen - headBLen);
        p1 = headA;
        p2 = headB;
        if(headALen < headBLen){
            while (d != 0){
                p2 = p2.next;
                d--;
            }
        }else {
            while (d != 0){
                p1 = p1.next;
                d--;
            }
        }
        while (p1 != null && p2 != null){
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    //快慢指针法：参考https://leetcode-cn.com/problems/intersection-of-two-linked-lists/comments/
    //headA, headB同时走，先到达链表底部把底部连到另外一个链表的头部形成一个环
    //这样两个指针在一个环上速度不一样，如果相交的话，最终会相遇在同一个节点

}
