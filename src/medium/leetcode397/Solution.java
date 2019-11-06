package medium.leetcode397;

/**
 * 整数替换:
 * 给定一个正整数 n，你可以做如下操作：
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1:
 * 输入:
 * 8
 *
 * 输出:
 * 3
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 * 输入:
 * 7
 * 输出:
 * 4
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 */
public class Solution {

    /**
     * 参考：https://leetcode-cn.com/problems/integer-replacement/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-10/
     * 位运算(贪心)：
     * 尽可能的使得n替换的次数最少
     * 如果n是偶数，直接除以2就行
     * 如果n是奇数，这时除了3之外，如果(n + 1)后能够被整除两次，那么n就选择加一，否则减一
     */
    public int integerReplacement(int n) {
        int count = 0;
        long m = n;
        while(m > 3){
            if(m % 2 == 0){
                m >>= 1;
                count++;
            }else{
                if(((m + 1) / 2) % 2 == 0){
                    m += 1;
                }else{
                    m -= 1;
                }
                count++;
            }
        }
        return count + (int)m - 1;
    }

}
