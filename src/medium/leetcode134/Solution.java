package medium.leetcode134;

/**
 * 加油站:
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * 示例 1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class Solution {

    /**
     * O(n^2)
     * 蛮力法：
     * 检查每一个加油站,选择该加油站为出发站,模拟汽车环路行驶，在每一个加油站检查我们还剩多少升汽油
     * 如果剩余的汽油不足以到下一个站就返回-1，否则继续向下走，如果又回到了起点就返回起点的索引
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int carGas = 0;
        for(int i = gas.length - 1; i >= 0; i--){
            carGas = gas[i];
            for(int j = (i + 1) % gas.length ;; j = (j + 1) % gas.length){
                int nextCarCost;
                if(j == 0){
                    nextCarCost = cost[cost.length - 1];
                }else {
                    nextCarCost = cost[j - 1];
                }
                carGas = carGas + gas[j] - nextCarCost;
                if(carGas < cost[j])
                    break;
                if(j == i)
                    return i;
            }
        }
        return -1;
    }


    /**
     * O（n）
     * 证明：https://leetcode-cn.com/problems/gas-station/solution/java-1ms-xiang-xi-shuo-ming-qi-shi-dian-xuan-qu-gu/
     * 一次遍历：
     * gas总量大于cost总量时一定存在某个站点能够开完全程，所以我们遍历整个加油站点，找出这个站点
     * 1、我们假设以startPos站点出发，用currTank记录行驶过程中剩余的油量，如果在某个站点currTank < 0, 说明从startPos出发无法到达当前站点
     * 2、同时到无法到达站点之前的任意站点也无法到达当前站点，所以当currTank < 0时，就可以直接更新startPos为当前站点(无法到达的站点)重新出发
     * 3、当某个startPos能够一直以currTank > 0到达最后的站点时，这个startPos就是返回结果
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;//记录整个路程总加油量与总油耗的差值
        int currTank = 0;//记录当前油箱的剩余油量
        int startPos = 0;//记录出发站点
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            //如果要到达下一站，但是剩余油量 < 0，说明不能从原本的startPos开始出发
            if (currTank < 0) {
                //选择下一个站点作为出发点
                startPos = i + 1;
                //清空油箱
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startPos : -1;
    }


}
