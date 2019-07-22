package easy.leetcode136;

/**
 * 只出现一次的数字:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution {

    /**
     * O(n):
     * 位操作 - 异或:
     * 将所有元素做异或运算，即nums[1] ⊕ nums[2] ⊕ nums[3] ⊕ …⊕ nums[n]，所得的结果就是那个只出现一次的数字
     * 原理就是：任何一个数字异或它自己都等于 0 ，即 n ^ n = 0, 而0和任何数字异或都等于这个数字，即 0 ^ n = n，且异或满足交换律和结合律
     */
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            ret ^= nums[i];
        }
        return ret;
    }

}
