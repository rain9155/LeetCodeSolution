package medium.leetcode264;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 丑数 II：
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 */
public class Solution {


    /**
     * 超时
     * 蛮力法：
     * 从1开始数，逐个判断是否是丑数，直到数到第n个丑数
     */
    public int nthUglyNumber(int n) {
        if(n < 1) return -1;
        int i = 1;
        while (true){
            if(isUgly(i))
                if(--n == 0) return i;
            i++;
        }
    }

    private boolean isUgly(int num) {
        if(num < 0) return false;
        while (num > 1){
            if(num % 2 == 0) num /= 2;
            else if(num % 3 == 0) num /= 3;
            else if(num % 5 == 0) num /= 5;
            else return false;

        }
        return num == 1;
    }

    /**
     * O（n）：
     * 过程:
     * 1、一开始第一个丑数为1，将 1 * 2放入q2，1 * 3放入q3，1 * 5放入q5；
     * 2、取三个队列中最小的为2，将2 * 2 = 4放入q2，2 * 3 = 6放入q3，2 * 5 = 10放入q5；
     * 3、取三个队列中最小的为3，将3 * 2 = 6放入q2，3 * 3 = 9放入q3，3 * 5 = 15放入q5；
     * ....
     * 6、取三个队列中最小的为min，将3 * 2 = 6放入q2，3 * 3 = 9放入q3，3 * 5 = 15放入q5；
     * 然后我们只需要在丑数数组中取index- 1个即可
     */
    public int nthUglyNumber2(int n) {
        if(n < 1) return -1;
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue3 = new LinkedList<>();
        Queue<Integer> queue5 = new LinkedList<>();
        int[] ret = new int[n];
        int min = 1;
        int i = 0;
        while (i < n){
            ret[i] = min;
            queue2.add(min * 2);
            queue3.add(min * 3);
            queue5.add(min * 5);
            min = Math.min(queue2.peek(), Math.min(queue3.peek(), queue5.peek()));
            if(min == queue2.peek()) queue2.poll();
            if(min == queue3.peek()) queue3.poll();
            if(min == queue5.peek()) queue5.poll();
            i++;
        }
        return ret[n - 1];
    }

    /**
     * O(n)
     * 使用额外的空间：
     * 1、定义一个数组，数组中第i个元素表示第i个丑数，再定义三个指针p1, p2, p3，分别代表相乘权重2，3，5
     * 2、把p1，p2，p3所指向数组的元素分别乘以相应的权重后，取其中的最小值就是数组的下一个丑数nextUglyNum
     * 3、把下一个丑数nextUglyNum放进数组，然后找出是哪个指针乘以权重得出的这个丑数
     * 4、找到这个指针后，把指针向后移动，这样所有指针乘以权重得出的数都会大于当前丑数
     * 就这样重复1，2，3，4直到遍历完数组，最终数组的最后一个元素就是第n个丑数
     */
    public int nthUglyNumber3(int n) {
        if(n <= 0){
            return -1;
        }
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for(int i = 1; i < n; i++){
            int nextUglyNum = Math.min(Math.min(uglyNum[p1] * 2, uglyNum[p2] * 3), uglyNum[p3] * 5);
            uglyNum[i] = nextUglyNum;
            if(uglyNum[p1] * 2 == nextUglyNum){
                p1++;
            }
            if(uglyNum[p2] * 3 == nextUglyNum){
                p2++;
            }
            if(uglyNum[p3] * 5 == nextUglyNum){
                p3++;
            }
        }
        return uglyNum[n - 1];
    }

}
