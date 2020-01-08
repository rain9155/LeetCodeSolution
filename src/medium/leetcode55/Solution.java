package medium.leetcode55;

import java.util.Arrays;

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
     * O(2^n)(超时)
     * 蛮力法(递归)：
     * 把每个位置的所有步数尝试一遍，只要有一种尝试可以走出数组(index == len), 就返回true，如果所有尝试不走不出数组，就返回false
     */
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        int max = nums[index];
        for (int i = max; i > 0; i--) {
            if (jump(nums, i + index)) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(n^2)
     * 自顶向下的动态规划：
     * 1、添加一个备忘录，长度和nums一样长，初始化为-1，代表未访问过
     * 2、在递归前，如果备忘录有记录了，就返回备忘录的记录
     * 3、在递归时，如果在index位置不可能跳出去了，就把它置为0，如果某个位置可以跳出去，就把它置为1
     */
    public boolean canJump2(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return jump(nums, 0, cache);
    }

    private boolean jump(int[] nums, int index, int[] cache) {
        if (index >= nums.length - 1) {
            return true;
        }
        if(cache[index] != -1){
            return cache[index] != 0;
        }
        if (nums[index] == 0) {
            return false;
        }
        int max = nums[index];
        for (int i = max; i > 0; i--) {
            if (jump(nums, i + index, cache)) {
                cache[index] = 1;
                return true;
            }
        }
        cache[index] = 0;
        return false;
    }



    /**
     * O（n）
     * 贪心算法：
     * 1、用一个max记录当前位置能到达的最大跳数
     * 2、然后每次比较max是否大于当前索引i
     *              如果小于，表示之前的最大跳数到达不了i位置，不可能跳出数组，返回false
     *              如果大于，表示从之前的位置可以跳到当前i位置，就更新max
     * 3、重复2，如果可以达数组末尾，表示可以跳出数组，就返回true
     */
    public boolean canJump3(int[] nums) {
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
