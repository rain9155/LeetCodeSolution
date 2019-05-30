package medium.leetcode55;

/**
 * 跳跃游戏:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution {

    /**
     * O（n）
     * 用一个max记录当前能到达的最大跳数，然后每次比较是否大于当前索引i，如果小于，表示之前的最大跳数到达不了i位置，返回false，如果大于，就会跳出循环，表示跳出了数组，返回true
     */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int i = 0;
        int max = 0;//用一个max记录当前能到达的最大跳数
        while (i < nums.length){
            if(max < i) return false;//之前最大的跳数都跳不到这里，肯定跳不出数组
            max = Math.max(max, nums[i] + i);
            i++;
        }
        return true;
    }

}
