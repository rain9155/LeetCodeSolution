package medium.leetcode384;

/**
 * 打乱数组：
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

import java.util.Random;

/**
 * 参考：https://leetcode-cn.com/problems/shuffle-an-array/solution/xi-pai-suan-fa-shen-du-xiang-jie-by-labuladong/
 * 洗牌算法：
 * 假设nums长度为n，则全排列有n！种可能
 * 这个题目的要求是从这个n！种可能中等概率的返回一种排列
 * 洗牌算法的思想：i从0开始到n - 1, 将i位置的数和random([i, n - 1])（包括i）之间位置的数交换, 这样就会得到一个随机排序
 */
public class Solution {

    private int[] original;
    private int[] shuffle;
    private Random random;

    public Solution(int[] nums) {
        original = nums;
        shuffle = original.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < shuffle.length; i++){
            int rand = random(i, shuffle.length - 1);
            swap(shuffle, i, rand);
        }
        return shuffle;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int random(int start, int end){
        return random.nextInt(end - start + 1) + start;
    }

}
