#pragma once
#include <vector>

/**
 * 盛最多水的容器：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]，在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49
 */
namespace Leetcode11
{
    class Solution 
    {
    public:
        /**
         * 双指针法：O（n）
         * 首先使用两个指针，一个放在开始，一个放在结束；
         * 然后计算两个指针所围成的面积，然后和上一个计算的比较，保存最大的；
         * 然后指针指向较短的向较长的移动一步，直到尾指针 <= 头指针
         */
        int maxArea(std::vector<int>& height) 
        {
            int maxArea = 0;
            int start = 0;
            int end = height.size() - 1;
            while (start < end)
            {
                int w = end - start;
                int h = 0;
                if(height[start] < height[end])
                {
                    h = height[start];
                    start++;
                }
                else
                {
                    h = height[end];
                    end--;
                }
                maxArea = std::max(maxArea, w * h);
            }
            return maxArea;
        }
    };
}