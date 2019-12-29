package easy.leetcode268;

/**
 * 缺失数字：
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Solution {


    /**
     * 一次遍历：
     * 例如nums = [3, 0, 1]
     * 1、在遍历的过程中，把所有的元素交换到它原本的位置，如nums[1] = 0, 那么0应该在nums[0]的位置，而不应该在nums[1]的位置
     * 2、在1遍历完后，nums会变成[0, 1, 3], 再遍历nums一次，找出元素与位置不符的索引，如这里nums[2] = 3，3占用了2的位置，所以2缺失了
     */
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i && nums[i] < nums.length){
                int index = nums[i];
                nums[i] = nums[index];
                nums[index] = index;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 位运算：
     * 和只出现一次的数字类似: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次, 找出那个只出现了一次的元素。
     * 所以如果我们补充一个完整的数组和原数组进行组合，那所求解的问题就变成了：只出现一次的数字。
     * 将少了一个数的nums数组与 0 到 n 之间完整的那个数组进行异或处理，因为相同的数字异或会变为了 0 ，那么全部数字异或后，剩下的就是少了的那个数字。
     */
    public int missingNumber2(int[] nums) {
        int ret = 0;
        int i = 0;
        while (i < nums.length){
            ret ^= i ^ nums[i];
            i++;
        }
        return ret ^ i;
    }


    //还可以使用求和的方法：
    //首先把完整的[1, n]数组求和，然后再把缺失数字的[1, n]求和，最后把这两个和相减，得出的差就是缺失的数字
    //注意：求和可能会产生溢出
}
