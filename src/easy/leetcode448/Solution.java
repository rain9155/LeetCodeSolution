package easy.leetcode448;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字:
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class Solution {


    /**
     * 参考leetcode442：
     * 通过不断的交换，把数字放回原位
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ret.add(i + 1);
            }
        }
        return ret;
    }

    /**
     * 基于异或交换两个数字：
     * 基于异或      基于加减
     * a = a ^ b    a = a + b
     * b = a ^ b    b = a - b
     * a = a ^ b	a = a - b
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    /**
     * 遍历一次数组，把相应元素的原位置为负数
     * [4,3,2,7,8,2,3,1] 初始数据
     * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
     * [4,3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,3,1]
     * [4,-3,-2,-7,8,2,-3,1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [4,-3,-2,-7,8,2,-3,-1]
     * [-4,-3,-2,-7,8,2,-3,-1]
     * 最后再遍历一次数组把元素不是负数的（索引+1）添加到结果中去，因为没有出现的数字的原位置还是正数
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for(int i = 0; i < nums.length; i++){
           if(nums[i] > 0){
               ret.add(i + 1);
           }
        }
        return ret;
    }



}
