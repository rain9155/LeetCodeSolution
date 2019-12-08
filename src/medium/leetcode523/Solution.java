package medium.leetcode523;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续的子数组和：
 * 给定一个包含非负数的数组和一个目标整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1:
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2:
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 * 说明:
 * 数组的长度不会超过10,000。
 * 你可以认为所有数字总和在 32 位有符号整数范围内。
 */
public class Solution {

    /**
     * 暴力：
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        k = Math.abs(k);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int sum = sum(nums, i, j);
                if(k > 0){
                    if(sum % k == 0){
                        return true;
                    }
                }else{
                    if(sum == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int sum(int[] nums, int i, int j){
        int sum = 0;
        while(i <= j){
            sum += nums[i];
            i++;
        }
        return sum;
    }

    /**
     * 优化的暴力：
     * 用一个数组预先累加nums中[0, i]的和
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        if(nums.length < 2) return false;
        k = Math.abs(k);
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int temp = sum[j] - sum[i];
                if(temp == k || (k != 0 && temp % k == 0)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 哈希表：
     * 在暴力中我们要通过判断(sum[j] - sum[i]) % k是否等于 0，如果(sum[j] - sum[i]) % k == 0，则返回true
     * 根据 mod 运算的性质，我们知道：
     *      (sum[j] - sum[i]) % k = 0 =》 sum[j] % k = sum[i] % k
     * 故若想 (sum[j] - sum[i]) % k = 0，则必有sum[j] % k = sum[i] % k
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        if(nums.length < 2) return false;
        if(nums[0] == 0 && nums[1] == 0) return true;
        k = Math.abs(k);
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0){
                int mod = sum % k;
                if(map.containsKey(mod)){
                    if(i - map.get(mod) > 1){
                        return true;
                    }
                }else {
                    map.put(mod, i);
                }
            }
        }
        return false;
    }

}
