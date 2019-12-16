package easy.leetcode27;

/**
 * 移除元素:
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution {


    /**
     * O(n^2)
     * 暴力法(双指针)：
     * 1、首先获取数组的长度len
     * 2、然后遍历这个nums，每当遇到元素等于val时，就把这个元素用后面的元素覆盖，然后len减一
     * 3、继续从当前位置开始遍历，直到到达len结尾
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length  == 0) return 0;
        int len = nums.length;
        int i = 0;
        while (i < len){
            if(nums[i] == val){
                for(int j = i + 1; j < len; j++){
                    nums[j - 1] = nums[j];
                }
                len--;
                i--;
            }
            i++;
        }
        return len;
    }

    /**
     * O(n)
     * 快慢指针：
     * 1、定义两个指针p1，p2，初始时p1，p2都指向第一个元素
     * 2、每当p2遇到满足条件:（p2指向的元素不等于val)的元素，就把它放进p1指向的元素，然后p1后移，如果p2遇到等于val的元素，就跳过即p2后移
     * 3、p1就是返回结果
     */
    public int removeElement2(int[] nums, int val) {
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
