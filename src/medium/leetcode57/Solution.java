package medium.leetcode57;

import java.util.*;

/**
 * 插入区间：
 * 给你一个无重叠的，按照区间起始端点排序的区间列表intervals，其中intervals[i] = [starti, endi]表示第i个区间的开始和结束，并且intervals按照starti升序排列。
 * 同样给定一个区间newInterval = [start, end]表示另一个区间的开始和结束。在intervals中插入区间 newInterval，使得intervals依然按照starti升序排列，
 * 且区间之间不重叠（如果有必要的话，可以合并区间），返回插入之后的 intervals。
 * 
 * 注意：
 * 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * 
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution {

    /**
     * 排序 + 区间合并：O(nlogn)
     * 先将新区间newInterval追加到区间列表intervals中
     * 然后对追加后的区间列表进行区间合并，参考leetcode56
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //先将新区间newInterval追加到区间列表intervals中
        int[][] newIntervals = new int[intervals.length + 1][2];
        for(int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;

        //然后对追加后的新区间列表newIntervals进行区间合并
        Arrays.sort(newIntervals, Comparator.comparingInt((interval) -> interval[0]));
        List<int[]> ret = new ArrayList<>();
        ret.add(new int[]{newIntervals[0][0], newIntervals[0][1]});
        for(int i = 1; i < newIntervals.length; i++) {
            int[] curInterval = newIntervals[i];
            int[] preInterval = ret.get(ret.size() - 1);
            if(curInterval[0] <= preInterval[1]) {
                ret.set(ret.size() - 1, new int[]{
                    preInterval[0], 
                    Math.max(preInterval[1], curInterval[1])
                });
            }else {
                ret.add(new int[]{
                    curInterval[0], 
                    curInterval[1]
                });
            }
        }
        return ret.toArray(new int[0][]);
    }

    /**
     * 一次遍历：O(n)
     * 遍历区间列表intervals，记当前遍历区间为interval，对于每个区间有三种情况：
     * 1、如果newInterval[1] < interval[0], 说明待插入区间当前遍历区间的左侧，没有交集，如果待插入区间没有加入答案就把它加入答案，然后将当前遍历区间加入答案
     * 2、如果newInterval[0] > interval[1], 说明待插入区间当前遍历区间的右侧，没有交集，将当前遍历区间加入答案
     * 3、否则说明待插入区间和当前遍历区间有交集，取当前遍历区间左端点和待插入区间左端点的最小值，以及当前遍历区间右端点和待插入区间右端点的最大值，作为待插入区间的新左右端点，然后继续遍历区间列表
     * 遍历结束，如果待插入区间还没有被加入答案，那么将它加入到答案中
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean insert = false;
        for(int[] interval : intervals) {
            if(right < interval[0]) {//待插入区间在当前遍历区间的左侧
                if(!insert) {
                    insert = true;
                    ret.add(new int[]{left, right});
                }
                ret.add(new int[]{interval[0], interval[1]});
            }else if(left > interval[1]) {//待插入区间当前遍历区间的右侧
                ret.add(new int[]{interval[0], interval[1]});
            }else {//待插入区间和当前遍历区间有交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!insert) {
            ret.add(new int[]{left, right});
        }
        return ret.toArray(new int[0][]);
    }
}
