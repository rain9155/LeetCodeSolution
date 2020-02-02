package medium.leetcode137;

/**
 * 只出现一次的数字 II:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     * 位运算：
     * 通过某种运算$，使a $ a $ a = 0，0 $ a = a：
     * 看到下面一堆与、或、非、异或运算应该很懵吧……下面一条条分析：
     * ones记录至目前元素，各位元素出现1次的位置；
     * twos记录至目前元素，各位元素出现2次的位置；
     * threes记录至目前元素，各位元素出现3次的位置 ;
     * 每轮完成时，当threes里某位为1时（代表此位出现了3次），需要将ones twos的对应位清零。
     * 这样将整个arr遍历后，出现3次的位都被置零了，留下的都是只出现一次的位，即one
     */
    public int singleNumber(int[] nums) {
        int one = 0;//one是一个32位的二进制，如果one中某一位为1，说明该位出现一次
        int two = 0;//two是一位32位的二进制，如果two中某一位为1，说明该位出现两次
        int three = 0;//three是一位32位的二进制，如果three中某一位为1，说明该位出现三次
        for(int num : nums){
            two |= one & num;//one和num & ，相同位为1，表示该位出现两次，用 | 保留在two中
            one ^= num;//one和num ^, 不同位为1，表示该位只出现一次
            three = one & two;//one与two & ,相同位为1，表示该位出现3次
            one &= ~three;//出现3次的位，在one中置零
            two &= ~three;//出现3次的位，在two中置零
        }
        return one;
    }

}
