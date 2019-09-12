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
     * 三指针法：
     * 一部分是丑数数组，另一部分是权重2，3，5。
     * 下一个丑数，定义为丑数数组中的数乘以权重，所得的最小值。
     * 那么，2该乘以谁？3该乘以谁？5该乘以谁？
     * 1、使用三个指针p2, p3, p5，告诉它们。比如，2应该乘以ugly[p2]，即数组中的第p2个值。（权重2，3，5分别对应指针p2, p3, p5）
     * 2，当命中下一个丑数时，说明该指针指向的丑数 乘以对应权重所得积最小。此时，指针应该指向下一个丑数
     * 3，要使用三个并列的if让指针指向一个更大的数，不能用if-else。因为有这种情况：
     *      丑数6，可能由于丑数2乘以权重3产生；也可能由于丑数3乘以权重2产生。
     *      丑数10，... 等等
     */
    public int nthUglyNumber3(int n) {
        if(n < 1) return -1;
        int[] ret = new int[n];
        ret[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int i = 1;
        while (i < n){
            int min = Math.min(ret[p2] * 2, Math.min(ret[p3] * 3, ret[p5] * 5));
            if(ret[p2] * 2 == min) p2++;
            if(ret[p3] * 3 == min) p3++;
            if(ret[p5] * 5 == min) p5++;
            ret[i] = min;
            i++;
        }
        return ret[n - 1];
    }

}
