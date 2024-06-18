package medium.leetcode215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 数组中的第K个最大元素:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 提示：
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class Solution {

    /**
     * 最大堆：O(nlogn)
     * 根据数组创建一个最大堆，对最大堆做 k-1 次删除操作，最后堆顶的元素就是数组nums的第k最大元素
     */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int heapSize = nums.length;
        Queue<Integer> maxHeap = new PriorityQueue<>(heapSize, Comparator.reverseOrder());
        for(int num : nums) {
            maxHeap.offer(num);
        }
        for(int i = nums.length - 1; i >= (nums.length - (k - 1)); i--) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    /**
     * 最小堆（维护一个长度为k的最小堆）：O(nlogk)
     * 1、遍历数组nums，不断的往堆中插入元素，当最小堆的长度大于k时，就弹出堆顶的元素
     * 2、最后堆顶的元素就是数组nums的第k最大元素
     */
    public int findKthLargest2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k, Comparator.naturalOrder());
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll();
    }

    /**
     * 桶排序：O(n)
     * 由于题目提示数组中的每个元素的范围为 -10^4 <= nums[i] <= 10^4
     * 所以我们可以创建一个大小为 20001 的 buckets 数组，然后使用计数排序数组中的元素
     * 然后在计数排序后的数组中从后往前查找数组中的第K个最大元素
     */
    public int findKthLargest3(int[] nums, int k) {
        if(nums.length == 0) return -1;
        int[] buckets = new int[20001];
        //这里每个元素加10000偏移量是为了让数组中的负数映射到正数中，从而映射到buckets数组的下标
        for(int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        //这里从后往前用k减去buckets数组中的值，即下标对应的数组元素的出现次数，小于等于0时
        //返回buckets数组的下标减去10000偏移量即数组中的第K个最大元素
        for(int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if(k <= 0) {
                return i - 10000;
            }
        }
        return -1;
    }

    /**
     * 分治法（快速排序的划分算法）：O(n)
     * 1、把找第 k 个最大元素变成找第 N - k 个最小元素
     * 2、使用划分算法随机选择一个枢轴，返回枢轴位置pos
     * 3、比较 pos 和 N - k 以决定在哪边继续递归处理
     * 这样就可以把原来快速排序递归两个区间变成只递归一个区间，时间复杂度由O(nlogn)降低为O(n)
     */
    public int findKthLargest4(int[] nums, int k) {
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
