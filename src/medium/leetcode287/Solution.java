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
     * O(nlogn):
     * 二分查找：
     * 因为数组大小为n + 1，数组中的元素大小范围为[1, n]，所以至少有一个元素重复出现
     * 我们可以对元素大小范围[1, n]做二分查找，查找重复出现的数在哪一个区间
     * 1、首先取[1, n]中间的数m，把[1, n]分为[1, m]和[m + 1, n]
     * 2、统计数组中在[1, m]范围内的数字有多少个
     *              如果数组中[1, m]范围内数字大于m个，说明重复数字在区间[1, m]那里
     *              如果数组中[1, m]范围内数字小于等于m个，说明重复数字在区间[m + 1, n]那里
     *    重复数字出现在哪个区间，就往哪个区间继续重复1、2进行二分查找
     * 3、把区间不断的缩小，缩小到只剩下一个数字，这个数字就是重复出现的数字
     */
    public int findDuplicate(int[] nums) {
        int left = 1;//left等于1
        int right = nums.length - 1;//right等于n
        while(left < right){
            //首先取[left, right]中间的数mid
            int mid = (left + right) >>> 1;
            int count = 0;
            //统计数组中在[left, mid]范围内的数字有多少个
            for(int i = 0; i < nums.length; i++){
                if(nums[i] >= left && nums[i] <= mid){
                    count++;
                }
            }
            //如果count大于mid个，说明重复数字在区间[left, mid]那里
            if(count > (mid - left + 1)){
                right = mid;
            }else{//如果count小于等于mid个，说明重复数字在区间[mid + 1, right]那里
                left = mid + 1;
            }
        }
        //最终left == right跳出循环，只剩下一个数字，这个数字就是重复出现的数字
        return left;
    }


    /**
     * O(n)
     * 快慢指针（按照寻找链表环入口的思路来做）：
     * fast 和 slow 是指针, nums[slow] 表示取指针对应的元素，因为 nums 数组中的数字都是在 1 到 n 之间， 所以在数组中进行游走不会越界，
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,例如：nums = [2,5,9,6,9,3,8,9,7,1]，
     * 构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]->1->5->3->6->8->7->[9]处循环。
     */
    public int findDuplicate2(int[] nums) {
        //先把slow和fast指针移动到链表头
        int slow = nums[0];
        int fast = nums[0];
        //快慢指针找环，相遇就跳出来，表示有环
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        //慢指针回到链表头
        slow = nums[0];
        //快慢指针以相同的速度向后移动，直到相遇，相遇点就是环入口，即数组中重复的元素
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



}
