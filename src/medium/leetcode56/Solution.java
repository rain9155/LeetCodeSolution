package medium.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution {

    /**
     * 先按首位置排序:
     * 1、先按首位置排序，然后区间首位置肯定是从小到大
     * 2、然后相邻区间的未位置和首位置两两比较，例如a = [1,4],b = [2,3]
     *    如果a[1] >= b[0]说明两个区间有重叠，就把这两个区间合并为一个新区间，新区间的首位置就是a[0], 而末位置则是max(a[1], b[1])
     * 3、重复2直到所有的相邻区间都比较过
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int r = intervals.length;
        List<int[]> tempList = new ArrayList<>();
        tempList.add(new int[]{intervals[0][0], intervals[0][1]});
        //两两区间比较合并
        for(int i = 1; i < r; i++){
            int[] interval = intervals[i];
            int[] two = tempList.get(tempList.size() - 1);
            if(two[1] >= interval[0]){
                two[1] = Math.max(two[1], interval[1]);//合并时
                tempList.set(tempList.size() - 1, two);
            }else{
                tempList.add(new int[]{interval[0], interval[1]});
            }
        }
        int[][] ret = new int[tempList.size()][2];
        for(int i = 0; i < tempList.size(); i++){
            ret[i][0] = tempList.get(i)[0];
            ret[i][1] = tempList.get(i)[1];
        }
        return ret;
    }


    /**
     * 先按首位置进行排序2;
     * 1、先按首位置排序，然后区间首位置肯定是从小到大
     * 2、接着如果相邻区间可以合并，就往右找，找出最大的右边界值，然后把这个几个区间合并成一个新区间，否则更新左边界和右边界
     * 3、重复2直到把所有要合并的区间合并
     */
    public int[][] merge2(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        if(intervals == null || intervals.length == 0) return ret.toArray(new int[0][]);
        int row = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while(i < row){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {//找出右边界
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            ret.add(new int[]{left, right});
            i++;
        }
        return ret.toArray(new int[0][]);
    }
}
