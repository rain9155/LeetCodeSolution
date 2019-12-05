package medium.leetcode621;

import java.util.Arrays;

/**
 * 任务调度器:
 * 定一个用字符数组表示的 CPU 需要执行的任务列表。
 * 其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 * CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *
 * 注：
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 */
public class Solution {

    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，如题优先排列A任务： A->X->X->A->X->X->A(X为其他任务或者待命)，得到完成A任务所需的最小时间minTime = （count - 1） * （n + 1） + 1 = 7
     * 3、再排序下一个任务，如果下一个任务个数和最大任务数一致，则minTime++，即把所有个数最大的任务先排好
     * 4、然后再把任务数比最大任务数小的任务插入X空位，因为间隔长度肯定会大于n，minTime就是所需的最小任务完成时间
     * 5、如果空位都插满之后还有任务，在这种情况下就是任务的总数是最小所需时间
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        //记录每个任务的数量
        for(char task : tasks){
            count[task - 'A']++;
        }
        //排序，任务数量从小到大排序
        Arrays.sort(count);
        //找出数量最多的任务
        int maxCount = count[count.length - 1];
        //先把数量最多的任务安排好，ret就是最短的任务完成时间
        int minTime = (maxCount - 1) * (n + 1) + 1;
        for(int i = count.length - 2; i >= 0; i--){
            //如果还有和maxCount一样多的任务，ret加1
            if(count[i] == maxCount){
                minTime++;
            }
        }
        //排除特殊情况：
        //如果所有的任务执行顺序是tasks的一个全排列，会导致ret的结果比真正的任务完成时间少
        //如AAABBBBCCDD，n = 2按照公式计算处理的ret = 6 ,但实际的任务执行顺序是A->B->C->A->B->C->A->B->D->D, 即实际的任务执行时间是tasks的长度，即10
        return Math.max(minTime, tasks.length);
    }

}
