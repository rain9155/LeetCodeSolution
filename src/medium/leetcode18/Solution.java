package medium.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class Solution {

    /**
     * 先排序，四数和转为三数和，三数和转为两数和，两数和用双指针法:O(n^3)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                for(int j = i + 1; j < nums.length - 2; j++){
                    if(j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])){
                        int start = j + 1;
                        int end = nums.length - 1;
                        int sum = target - nums[i] - nums[j];
                        while (start < end){
                            int temp = nums[start] + nums[end];
                            if(temp == sum){
                                List<Integer> list = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                                ret.add(list);
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (end > start && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            }else if(temp < sum){
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                start++;
                            }else {
                                while (end > start && nums[end] == nums[end - 1]) end--;
                                end--;
                            }
                        }
                    }
                }
            }

        }
        return ret;
    }

}
