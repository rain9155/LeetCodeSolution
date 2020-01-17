package medium.leetcode875;

/**
 * 爱吃香蕉的珂珂:
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *  
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class Solution {

    /**
     * 二分查找：
     * 1、先出香蕉堆中找出香蕉的最大堆的数量，这是可可一个小时能吃的最大数量，最小数量为1
     * 2、在最小数量和最大数量之间找到第一个能让可可在H之前吃完所有香蕉的数量
     */
    public int minEatingSpeed(int[] piles, int H) {
        if(piles.length == 0 || piles.length > H){
            return 0;
        }
        int min = 1;
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        while(min < max){
            int mid = min + ((max - min) >> 1);
            if(!canEat(piles, mid, H)){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    private boolean canEat(int[] piles, int speed, int H){
        int time = 0;
        for(int i = 0; i < piles.length; i++){
            time += ((piles[i] - 1) / speed + 1);
        }
        return H >= time;
    }
}
