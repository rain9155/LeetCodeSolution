package easy.leetcode204;

/**
 * 计数质数：
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 */
public class Solution {

    /**
     * 超时
     * 枚举法：
     * 质数就是只能被1和自身整除，判断m是不是质数，只需要把m与[2, √m]范围的数相除，看有没有数和m整除，如果有就表示m不是质数，如果没有就表示m是质数
     */
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        int count = 0;
        for(int i = 2; i < n; i++){
            count++;
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 厄拉多塞筛法：
     * 根据质数的性质，如果一个数是质数，那么质数的倍数就不可能是质数，从而有以下规律：
     * 首先，把[2, n)范围内的所有整数用一个表都记下来，其中最小数字2是质数，然后将表中2的所有倍数都划去，
     * 然后到下一个数3，它是质数，然后将表中3的所有倍数都划去，
     * 然后下一个数是5，它是质数，然后将表中5的所有倍数都划去，
     * ...
     * 这样表中剩下的数都是质数
     */
    public int countPrimes2(int n) {
        if(n <= 1) return 0;
        int count = 0;
        boolean[] primes = new boolean[n];//初始化一个数组，默认n个数都是质数, false表示这个位置的数是质数，true表示不是
        for(int i = 2; i < n; i++){
            if(!primes[i]){
                count++;
                for(int j = i + i; j < n; j += i){
                    primes[j] = true;
                }
            }
        }
        return count;
    }

}
