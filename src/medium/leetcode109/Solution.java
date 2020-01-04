package medium.leetcode109;

import common.node.ListNode;
import common.node.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 有序链表转换二叉搜索树:
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution {

    /**
     * 递归 + 链表转数组
     * 按照108题的思路，先把把链表转成数组，然后再分治构造二叉搜索树
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new LinkedList<>();
        ListNode p1 = head;
        while (p1 != null){
            list.add(p1.val);
            p1 = p1.next;
        }
        Integer[] nums = list.toArray(new Integer[0]);
        return sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(Integer[] nums) {
        if(nums == null || nums.length == 0) return null;
        return arrayToBST(nums, 0, nums.length - 1);
    }

    @SuppressWarnings("Unchecked")
    private TreeNode arrayToBST(Integer[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        int val = nums[mid];
        TreeNode root = new TreeNode(val);
        root.left = arrayToBST(nums, start, mid - 1);
        root.right = arrayToBST(nums, mid + 1, end);
        return root;
    }

    /**
     * 递归 + 快慢指针
     * 由于我们得到的是一个有序链表而不是数组，我们不能直接使用下标来访问元素。我们需要知道链表中的中间元素。
     * 我们可以利用两个指针来访问链表中的中间元素。假设我们有两个指针 slow_ptr 和 fast_ptr。slow_ptr 每次向后移动一个节点而 fast_ptr 每次移动两个节点。
     * 当 fast_ptr 到链表的末尾时 slow_ptr 就访问到链表的中间元素，记为midListNode
     * 当找到链表中的中间元素后，我们将链表从中间元素的左侧断开，做法是使用一个 prev_ptr 的指针记录 slow_ptr 之前的元素，也就是满足 prev_ptr.next = slow_ptr，断开左侧部分就是让 prev_ptr.next = None。
     * 所以递归调用的时候，左半部分我们只需要将链表的头指针传递给转换函数，右半部分传midListNode.next
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) return null;
        ListNode midListNode = findMidListNode(head);
        TreeNode root = new TreeNode(midListNode.val);
        if(midListNode == head) return root;
        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(midListNode.next);
        midListNode.next = null;
        return root;
    }

    /**
     * 使用快慢指针找到链表的中间元素,快指针比慢指针走快两步，当快指针到达链表的尾部时，慢指针就到达链表的中间
     */
    private ListNode findMidListNode(ListNode head){
        ListNode slowP = head;
        ListNode fastP = head;
        ListNode preSlowP = null;
        while (fastP != null && fastP.next != null){
            preSlowP = slowP;
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        if(preSlowP != null) preSlowP.next = null;
        return slowP;
    }

}
