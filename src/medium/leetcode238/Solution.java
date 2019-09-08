package medium.leetcode238;

/**
 * 除自身以外数组的乘积:
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Solution {

    /**
     * O(n)
     * 从两边遍历数组：
     * 除自身以外数组的乘积 = 左边乘积 * 右边乘积
     * 所以遍历两次数组nums，第一次遍历，从左往右，计算output[i]的左边乘积
     *                      第二次遍历，从右往左，计算output[i]的右边乘积的同时再乘上output[i]，就是结果
     */
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        int temp = 1;
        for(int i = 1; i < nums.length; i++){
            temp *= nums[i - 1];
            output[i] = temp;
        }

        temp = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            temp *= nums[i + 1];
            if(i == 0){
                output[i] = temp;
            }else {
                output[i] *= temp;
            }
        }
        return output;
    }

}
