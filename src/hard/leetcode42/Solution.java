package hard.leetcode42;

/**
 * 接雨水:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {

    /**
     * O(n^2)
     * 蛮力法：
     * 遍历height数组，计算height[i]最多能够装多少水，然后累加每个i位置所装的水量，height[i]最多能装多少水取决于左右两边最高柱子中的最短那根，然后再减去i位置的柱子高度，即mix(l_max, r_max) - height[i]
     */
    public int trap(int[] height) {
        int ret = 0;
        for(int i = 0; i < height.length; i++){
            int l_max = 0;
            int r_max = 0;
            for(int j = i; j >= 0; j--){
                l_max = Math.max(l_max, height[j]);
            }
            for(int j = i; j < height.length; j++){
                r_max = Math.max(r_max, height[j]);
            }
            ret += Math.min(l_max, r_max) - height[i];
        }
        return ret;
    }

    /**
     * O(n)
     * 备忘录优化：
     * 使用两个数组分别缓存每个位置i的左右两边最高柱子高度，例如l_max[i]表示[0, i]中最高的柱子高度，r_max[i]表示[i, len - 1]中最高的柱子高度
     */
    public int trap2(int[] height) {
        if(height.length == 0) return 0;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];
        //缓存每个位置左右两边的最高柱子高度, l_max从左到右求，r_max从右到左求
        for(int i = 1, j = height.length - 2; i < height.length && j >= 0; i++, j--){
            l_max[i] = Math.max(l_max[i - 1], height[i]);
            r_max[j] = Math.max(r_max[j + 1], height[j]);
        }
        int ret = 0;
        for(int i = 0; i < height.length; i++){
            ret += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return ret;
    }

    /**
     * O(n)
     * 双指针：
     * 1、把备忘录的两个数组改用两个变量表示：l_max，r_max，l_max表示[0, i]中最高的柱子高度，r_max表示[i, len - 1]中最高的柱子高度
     * 2、然后用两个指针left，right分别执行height的头尾，left用来从左到右更新l_max，right用来从右到左更新r_max
     * 3、当l_max < r_max时，更新l_max，移动left， 否则，更新r_max, 移动r_max, 同时求出i位置的能装的水量累加
     */
    public int trap3(int[] height) {
        if(height.length == 0) return 0;
        int l_max = height[0];
        int r_max = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int ret = 0;
        while (left <= right){
            if(l_max < r_max){
                l_max = Math.max(l_max, height[left]);
                ret += l_max - height[left];
                left++;
            }else {
                r_max = Math.max(r_max, height[right]);
                ret += r_max - height[right];
                right--;
            }
        }
        return ret;
    }

}
