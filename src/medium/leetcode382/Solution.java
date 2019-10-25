package medium.leetcode382;

import common.struction.ListNode;

import java.util.Arrays;
import java.util.Random;

/**
 * 链表随机节点：
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 示例:
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 *
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
public class Solution {

    private int mInitLen = 10;
    private int mLen = mInitLen;
    private int mCurIndex = 0;
    private int[] mNums = new int[mInitLen];
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        ListNode p = head;
        while (p != null){
            if(mCurIndex == mLen){
                resize();
            }
            mNums[mCurIndex] = p.val;
            p = p.next;
            mCurIndex++;
        }
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = random.nextInt(mCurIndex);
        return mNums[index];
    }

    private void resize(){
        int newLen = mNums.length << 2 + 1;
        int[] newNums =  Arrays.copyOf(mNums, newLen);
        mNums = newNums;
        mLen = newLen;
    }

}
