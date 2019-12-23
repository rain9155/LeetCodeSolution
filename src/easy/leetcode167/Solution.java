package easy.leetcode167;

/**
 * 两数之和 II - 输入有序数组:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution {

    /**
     * O(n)
     * 双指针法：
     * 因为数组是有序的，所以，从左往右，元素值依此增大
     * 1、设置两个指针，p1在头部，p2在尾部
     * 2、如果p1和p2所指元素的和 == target，就返回p1，p2
     * 3、如果p1和p2所指元素的和 > target, 则p2--；如果p1和p2所指元素的和 < target, 则p1++
     */
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        while (p1 < p2){
            if(numbers[p1] + numbers[p2] == target){
                return new int[]{p1 + 1, p2 + 1};
            }else if(numbers[p1] + numbers[p2] > target){
                p2--;
            }else {
                p1++;
            }
        }
        return new int[]{-1, -1};
    }

}
