package easy.leetcode26;

/**
 * 删除排序数组中的重复项:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {


    /**
     * O（n^2）
     * 暴力法 + 双指针：
     * 1、首先放置两个指针p1, p2, p1指向头元素，p2指向尾元素
     * 2、遍历整个数组，如果p1指向元素与下一个元素重复时，就从p1指向的元素开始，后一个元素赋值给前一个元素，然后p2减一，否则p加一，指向下一个元素
     * 3、最终等p1 == p2就停止，p1 + 1就是不重复元素的长度
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2){
            if(nums[p1] == nums[p1 + 1]){
                for(int i = p1; i < nums.length - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                p2--;
            }else {
                p1++;
            }
        }
        return p1 + 1;
    }

    /**
     * O（n）
     * 双指针（快慢指针）:
     * 1、放置两个指针i， j， i指向第一个元素，j指向第二个元素
     * 2、当j指向的元素与i指向的元素相等时，j后移，直到出现j指向的元素不等于i指向的元素，i后移一位，然后把j指向的元素赋值给i指向的元素
     * 3、i 与 j永远相隔着n个相等的元素，
     */
    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
