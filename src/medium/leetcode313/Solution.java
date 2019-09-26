package medium.leetcode313;

import java.util.Arrays;

/**
 * 超级丑数:
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 *
 * 示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 *
 * 说明:
 * 1 是任何给定 primes 的超级丑数。
 *  给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 */
public class Solution {

    /**
     * 参考264：
     * uglys为根据primes得到的丑数数组，最后一个数据即返回结果
     * 1、初始化 uglys第一个元素为1
     * 2、为primes中的每一个质数都给定一个在uglys中的index，由此得到index数组，初始化为0
     * 3、遍历1`n，同时遍历primes，得到每个数与它在uglys中相应index下标的数相乘的结果的最小值，这个最小值就是下一个丑数，同时得到minIndex，即在primes中的质数的下标
     * 4、同时更新index数组，minIndex位置向后移动一位，同时还要在primes中找出除了minIndex外乘以uglys的某个数与得到的丑数相等的质数的下标，把这个下标对应的index也要后移一位，避免下一次出现重复丑数
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes.length == 0) return 0;
        int[] index = new int[primes.length];
        int[] uglys = new int[n];
        Arrays.fill(index, 0);
        Arrays.fill(uglys, Integer.MAX_VALUE);
        uglys[0] = 1;
        for(int i = 1; i < n; i++){
            int minIndex = 0;
            //primes中每个数与它在uglys中相应下标的数相乘的结果的最小值就是下一个丑数
            for(int j = 0; j < primes.length; j++){
                int num = uglys[index[j]] * primes[j];
                if(num < uglys[i] ){
                    uglys[i] = num;
                    minIndex = j;
                }
            }
            index[minIndex]++;
            //还需要检查primes中每个数与它在uglys中相应下标的数相乘的结果是否等于丑数，如果相等，则相应的index也要后移
            //避免下一次出现重复丑数
            for(int j = 0; j < primes.length; j++){
                if(j == minIndex) continue;
                if(primes[j] * uglys[index[j]] == uglys[i]){
                    index[j]++;
                }
            }
        }
        return uglys[n - 1];
    }

}
