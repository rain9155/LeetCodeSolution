package medium.leetcode452;

import java.util.*;

/**
 * 用最少数量的箭引爆气球:
 * 有一些球形气球贴在一堵用XY平面表示的墙面上, 墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出, 在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为xstart，xend， 且满足 xstart ≤ x ≤ xend，则该气球会被引爆
 * 给你一个数组points ，返回引爆所有气球所必须射出的最小弓箭数 
 * 
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * 在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * 在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * 在x = 4处射出箭，击破气球[3,4]和[4,5]
 */
public class Solution {

    /**
     * 排序 + 区间交集：O(nlogn)
     * 对points区间列表进行从小到大排序，然后遍历区间列表，和答案中的区间比较
     * 1、如果当前遍历区间和答案中的区间相交，就取两个区间的交集区间，然后更新答案中的区间
     * 2、如果当前遍历区间和答案中的区间不想交，就把当前遍历区间放入答案中
     * 最终答案中保存的区间交集数量就是引爆所有气球所必须射出的最小弓箭数
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((point) -> point[0]));
        List<int[]> ret = new ArrayList<>();
        ret.add(new int[]{points[0][0], points[0][1]});
        for(int i = 1; i < points.length; i++) {
            int[] curInterval = points[i];
            int[] preInterval = ret.get(ret.size() - 1);
            if(curInterval[0] <= preInterval[1]) {//两个区间有交集，取两个区间的交集区间
                ret.set(ret.size() - 1, new int[]{
                    Math.max(preInterval[0], curInterval[0]), 
                    Math.min(preInterval[1], curInterval[1])
                });
            }else {
                ret.add(new int[]{
                    curInterval[0], 
                    curInterval[1]
                });
            }
        }
        return ret.size();
    }
}
