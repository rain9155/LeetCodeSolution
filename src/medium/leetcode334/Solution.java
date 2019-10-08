package medium.leetcode334;

/**
 * 递增的三元子序列:
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Solution {

    /**
     * 三指针：
     * 维护3个指针，分别代表最小值，次最小值，最大值
     * 在遍历nums时如果可以满足nums[one] < nums[two] < nums[three]，则返回true，否则返回false
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = 0;
        while (three < nums.length){
            if(nums[three] <= one){//当前遍历值比最小值小，让它成为最小值
                one = nums[three];
            }else if(nums[three] <= two){//当前遍历值比最小值大，让它成为次最小值
                two = nums[three];
            }else {//当前遍历值比次最小值大，让它成为最大值，找到了递增的三元子序列，返回true
                return true;
            }
            three++;
        }
        return false;
    }

}
