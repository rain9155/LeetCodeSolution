package medium.leetcode15;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class Solution {

    /**
     * 先排序，后蛮力法：（O(n^3)）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Utils.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int t = j + 1; t < nums.length; t++){
                    if(nums[i] + nums[j] + nums[t] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[t]);
                        if(!ret.contains(list)) ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    /**
     * O(n^2)
     * 先排序，定义三个指针，i，j，k，遍历i，
     * 那么这个问题就可以转化为在i之后的数组中寻找 nums[j] + nums[k] = 0 - nums[i] 这个问题，
     * 也就将三数之和问题转变为二数之和, 用双指针遍历求两数之和。
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            //因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int j = i + 1;
                int k = nums.length - 1;
                int sum = 0 - nums[i];
                while (j < k){
                    if(nums[j] + nums[k] == sum){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        ret.add(list);
                        //因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (k > j && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    }else if(nums[j] + nums[k] < sum){//两个数相加小于sum，因为数组是有序的，越往右数值越大，所以此时 j 往右，两个数相加才可能等于sum
                        //因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        j++;
                    }else {//两个数相加大于sum，因为数组是有序的，越往左数值越小，所以此时 k 往左，两个数相加才可能等于sum
                        //因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                        while (k > j && nums[k] == nums[k -1]) k--;
                        k--;
                    }
                }
            }
        }
        return ret;
    }



}
