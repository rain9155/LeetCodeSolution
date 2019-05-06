package medium.leetcode11;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai),
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0);
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Solution {

    /**
     * 蛮力法（O（n^2））
     */
    public int maxArea(int[] height) {
        int maxValue = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int len = height[i] > height[j] ? height[j] : height[i];
                int width = j - i;
                maxValue = Math.max(maxValue, width * len);
            }
        }
        return maxValue;
    }

    /**
     * 双指针法：（O（n））
     * 首先使用两个指针，一个放在开始，一个放在结束；
     * 然后计算两个指针所围成的面积，然后和上一个计算的比较，保存最大的；
     * 然后指针指向较短的向较长的移动一步；
     * 直到尾指针 <= 头指针
     */
    public int maxArea2(int[] height) {
        int maxValue = 0;
        int start = 0, end = height.length - 1;
        while (start < end){
            int width = end - start;
            int len;
            if(height[start] > height[end]){
                len = height[end];
                end--;
            }else {
                len = height[start];
                start++;
            }
            maxValue = Math.max(maxValue, len * width);
        }
        return maxValue;
    }

}
