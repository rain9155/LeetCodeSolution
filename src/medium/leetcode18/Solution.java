package medium.leetcode18;

import java.util.*;

/**
 * 四数之和:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class Solution {

    /**
     * O(n^3)
     * 双指针：(参考15题)
     * 先排序，四数和转为三数和，三数和转为两数和，两数和用双指针法
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                    int start = j + 1;
                    int end = nums.length - 1;
                    int sum = target - nums[i] - nums[j];
                    while (start < end){
                        int temp = nums[start] + nums[end];
                        if(temp == sum){
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                            set.add(list);
                            start++;
                            end--;
                        }else if(temp < sum){
                            start++;
                        }else {
                            end--;
                        }
                    }

            }
        }
        return  new ArrayList<List<Integer>>(set);
    }

}
