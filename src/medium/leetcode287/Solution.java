package medium.leetcode287;

/**
 * 寻找重复数：
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Solution {

    /**
     * 快慢指针（按照寻找链表环入口的思路来做）：
     * fast 和 slow 是指针, nums[slow] 表示取指针对应的元素，因为 nums 数组中的数字都是在 1 到 n 之间， 所以在数组中进行游走不会越界，
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,例如：nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]，
     * 构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                fast = 0;
                while (nums[fast] != nums[slow]){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];
            }
        }
    }

}
