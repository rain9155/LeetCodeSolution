package medium.leetcode215;

import common.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 数组中的第K个最大元素:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution {

    /**
     * O(nlogk)
     * 最小堆（维护一个长度为k的最小堆）：
     * 1、遍历数组nums，不断的往堆中插入元素，当最小堆的长度大于k时，就弹出堆顶的元素
     * 2、最后堆顶的元素就是数组nums的第k最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        PriorityQueue<Integer> head = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int num : nums){
            head.add(num);
            if(head.size() > k) head.poll();
        }
        return head.poll();
    }

    /**
     * O(n)
     * 分治法（快速排序的划分算法）：
     * 1、把第 k 个最大元素变成第 N - k 个最小元素
     * 2、使用划分算法随机选择一个枢轴，返回枢轴位置pos
     * 3、比较 pos 和 N - k 以决定在哪边继续递归处理
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSorts(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSorts(int[] nums, int left, int right, int k){
        //nums只包含一个元素
        if(left == right){
            return nums[left];
        }
        //找出中枢位置
        int pivot = partition(
                nums,
                left,
                right,
                left + new Random().nextInt(right - left + 1)//随机选择一个key的位置
        );
        if(pivot == k){//如果中枢位置等于k，直接返回
            return nums[pivot];
        }else if(pivot < k){//如果中枢位置小于k，说明第k小元素在nums中枢的右边
            return quickSorts(nums, pivot + 1, right, k);
        }else {//如果中枢位置大于k，说明第k小元素在nums中枢的左边
            return quickSorts(nums, left, pivot - 1, k);
        }

    }

    private int partition(int[] nums, int left, int right, int pivot_index){
        swap(nums, pivot_index, left);
        int key = nums[left];
        int pivot = left;
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < key){//从左边开始找，只要比key小，就交换
                pivot++;
                swap(nums, i, pivot);
            }
        }
        swap(nums, pivot, left);
        return pivot;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
