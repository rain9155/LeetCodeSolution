package medium.leetcode398;

/**
 * 随机数索引:
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 */

import java.util.Random;

/**
 * 参考：
 * https://leetcode-cn.com/problems/random-pick-index/solution/xu-shui-chi-chou-yang-by-jason-2/
 * https://www.jianshu.com/p/7a9ea6ece2af
 * 蓄水池采样：
 * 在数据流n未知的情况下，从数据流中取m个数据，保证每个数据都是以m/n概率获取的
 * 对于本题：
 * 在数据流nums中，n未知，从中获取target的索引，保证每个索引的返回概率相等，target在nums中存在重复
 * 所以可以定义 蓄水池m = 1
 * 1、维护一个计数器count，记录target的数量
 * 2、每当遇到target时，
 *      如果count < 1, 把target的索引值i放入蓄水池中，
 *      如果count > 1,就随机取[0, count + 1]范围的数，记为index，当index < 1时，用当前i替换掉入蓄水池中的值
 *      最后计数器加一
 * 一直重复1、2，直到数据流遍历完，这时蓄水池中保留的索引就是在nums[i] == target的前提下，以1/count概率获取的
 */
public class Solution {


    int[] data;

    public Solution(int[] nums) {
        data = nums;
    }

    public int pick(int target) {
        int ret = 0;
        int count = 0;
        Random rand = new Random();
        for(int i = 0; i < data.length; i++){
            if(data[i] == target){
                if(count < 1){
                    ret = i;
                }else{
                    int index = rand.nextInt(count + 1);
                    if(index < 1){
                        ret = i;
                    }
                }
                count++;
            }
        }
        return ret;
    }

}
