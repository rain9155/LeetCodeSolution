#pragma once
#include <vector>

/**
 * 三数之和：
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c 
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1:
 * 输入：nums = [-1, 0, 1, 2, -1, -4]，
 * 输出：[[-1, 0, 1],[-1, -1, 2]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] ，注意，输出的顺序和三元组的顺序并不重要
 * 
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 
 * 
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 
 */
namespace Leetcode15
{
    class Solution
    {
    public:
        /**
         * 双指针：O(n^2)
         * 先排序，定义三个指针，i，j，k，遍历i，
         * 那么这个问题就可以转化为在i之后的数组中寻找 nums[j] + nums[k] = 0 - nums[i] 这个问题，
         * 也就将三数之和问题转变为二数之和, 用双指针遍历求两数之和。
         */
        std::vector<std::vector<int>> threeSum(std::vector<int>& nums) 
        {
            std::vector<std::vector<int>> ret;
            std::sort(nums.begin(), nums.end());
            for(int i = 0; i < nums.size() - 2; i++)
            {
                if(i == 0 || nums[i] != nums[i - 1])//因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                {
                    int j = i + 1;
                    int k = nums.size() - 1;
                    int target = 0 - nums[i];
                    while (j < k)
                    {
                        int sum = nums[j] + nums[k];
                        if(sum == target)//两数相加等于target，满足条件
                        {
                            ret.push_back({nums[i], nums[j], nums[k]});
                            while (j < k && nums[j] == nums[j + 1])//因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                            {
                                j++;
                            }
                            while (j < k && nums[k] == nums[k - 1])//因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                            {
                                k--;
                            }
                            j++;
                            k--;
                            
                        }
                        else if(sum < target)//两个数相加小于target，因为数组是有序的，越往右数值越大，所以此时 j 往右，两个数相加才可能等于target
                        {
                            while (j < k && nums[j] == nums[j + 1])//因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                            {
                                j++;
                            }
                            j++;
                        } 
                        else//两个数相加大于target，因为数组是有序的，越往左数值越小，所以此时 k 往左，两个数相加才可能等于target
                        {
                            while (j < k && nums[k] == nums[k - 1])//因为数组是有序的，所以如果相邻的数值相等，就跳过重复的数值
                            {
                                k--;
                            }
                            k--;
                        }
                    }
                }
            }
            return ret;
        }
    };
}