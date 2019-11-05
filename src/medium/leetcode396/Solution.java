package medium.leetcode396;

/**
 * 旋转函数:
 * 给定一个长度为 n 的整数数组 A 。
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 注意:
 * 可以认为 n 的值小于 105。
 *
 * 示例:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 */
public class Solution {

    /**
     * O(n^2)
     * 找规律：
     * 例如n = 4， A = [4, 3, 2, 6]
     * 第一轮：F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6)， 没有先计算的乘积，计算和4、3、2、6的乘积
     * 第二轮：F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2)，先计算和6的乘积，再计算和4、3、2的乘积
     * 第三轮：F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3)，先计算和2、6的乘积，再计算和4、3的乘积
     * 第 i 轮：F(i) = ...以此类推得出：先计算的子数组的索引在A的位置为n - i
     * 所以每一轮，先从[n - i, n)的范围开始计算乘积，接着再从[0, n - i)的范围计算剩下没有计算的乘积
     */
    public int maxRotateFunction(int[] A) {
        if(A.length < 1) return 0;
        int max = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = 0; i < n; i++){
            int first = n - i;
            int temp = 0;
            int rato = 0;
            for(int j = first; j < n; j++){
                temp += (rato * A[j]);
                rato++;
            }
            for(int j = 0; j < first; j++){
                temp += (rato * A[j]);
                rato++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    /**
     * O(n)
     * 错位相减：
     * 假设n = 4， A= [4,3,2,6], A的各项和为sum
     * 则每一轮的变化为：[4, 3, 2, 6] -> [6, 4, 3, 2] -> [2, 6, 4, 3] -> [3, 2, 6, 4];
     * 例如：
     * F(0) = 0 * 4 + 1 * 3 + 2 * 2 + 3 * 6,
     * F(1) = 0 * 6 + 1 * 4 + 2 * 3 + 3 * 2;
     * 由F(0)变成F(1), 需要将最后一项3 * 6减去, 并加多自己一次
     * 也就是：F(1) = F(0) - (n-1) * A[最后一项] + sum，但不需要最后一项6,
     * 即：F(1) = F(0) - (n-1) * A[最后一项] + sum - A[最后一项],
     * 最终化简为：F(i) = F(i - 1) + sum - n * A[ n-i]
     */
    public int maxRotateFunction2(int[] A) {
        if(A.length < 1) return 0;
        int n = A.length;
        int[] Fn = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            Fn[0] += (i * A[i]);
            sum += A[i];
        }
        int max = Fn[0];
        for(int i = 1; i < n; i++){
            Fn[i] = Fn[i - 1] + sum - n * A[n - i];
            max = Math.max(max, Fn[i]);
        }
        return max;
    }

}
