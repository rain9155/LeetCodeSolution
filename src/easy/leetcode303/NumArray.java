package easy.leetcode303;

/**
 * 区域和检索 - 数组不可变:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例:
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 说明:
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 *
 */

/**
 * 哈希表：
 * 用一个一维数组datas缓存[0, i]累加的和，然后在求[i, j]范围的和时，只需要返回datas[j + 1] - datas[i]
 */
public class NumArray {

    final int[] datas;
    final int len;


    public NumArray(int[] nums) {
        len = nums.length;
        datas = new int[len + 1];
        for(int i = 0; i < len; i++){
            datas[i + 1] = datas[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j > len - 1){
            return 0;
        }
        return datas[j + 1] - datas[i];
    }

}


