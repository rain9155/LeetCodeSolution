package easy.leetcode27;

/**
 * 移除元素:
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {

    /**
     * O(n)
     * 快慢指针：
     * 定义两个指针p1，p2，初始时p1，p2都指向第一个元素
     * 每当p2遇到满足条件即p2指向的元素不等于val，就把它放进p1指向的元素，然后p1后移，如果p2遇到等于val的元素，就跳过即p2后移
     * p1就是返回结果
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length  == 0) return 0;
        int p1 = 0;
        for(int p2 = 0; p2 < nums.length; p2++){
            if(nums[p2] != val){
                nums[p1] = nums[p2];
                p1++;
            }
        }
        return p1;
    }

}
