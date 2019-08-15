package easy.leetcode202;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数:
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Solution {

    /**
     * 找规律：
     * 不断的取出n的最后一位，累加平方和，如果等于1，直接返回true，如1，19等
     * 如果一直不等于1，直到n重复出现，返回false，如：对于 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 ，4不是快乐数
     * 所以我们还要用一个集合保存出现过的结果
     */
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        set.add(n);
        while (ret != 1){
            ret = 0;
            while (n != 0){
                int num = n % 10;
                ret += num * num;
                n /= 10;
            }
            if(set.contains(ret)) return false;
            set.add(ret);
            n = ret;
        }
        return true;
    }

}
