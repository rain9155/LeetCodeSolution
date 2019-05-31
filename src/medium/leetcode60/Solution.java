package medium.leetcode60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第k个排列：
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Solution {

    private int cur = 0;

    /**
     * 回溯法：
     * 回溯生成所有排列，当等于第k个时就返回
     */
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0) return "";
        StringBuilder ret = new StringBuilder();
        permutation(n, k, new ArrayList<>(), ret);
        return ret.toString();
    }

    private void permutation(int n, int k, List<Integer> temp, StringBuilder ret){
        if(temp.size() == n){
            cur++;
            if(k == cur){
                for(int num : temp) ret.append(num);
                return;
            }
        }
        for(int i = 1; i <= n; i++){
            if(temp.contains(i)) continue;
            temp.add(i);
            permutation(n, k, temp, ret);
            temp.remove(Integer.valueOf(i));
        }
    }

    /**
     * 回溯法2：
     * 回溯生成所有排列，当等于第k个时就返回, 用一个visit[]记录访问过的元素
     */
    public String getPermutation2(int n, int k) {
        if(n <= 0 || k <= 0) return "";
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        //生成n！
        for(int i = 1; i <= n; i++) factorials[i] = i * factorials[i - 1];
        boolean[] visit = new boolean[factorials[n] + 1];
        StringBuilder ret = new StringBuilder();
        permutation2(n, k, visit, new ArrayList<>(), ret);
        return ret.toString();
    }

    private void permutation2(int n, int k, boolean[] visit, List<Integer> temp, StringBuilder ret){
        if(temp.size() == n){
            cur++;
            if(k == cur){
                for(int num : temp) ret.append(num);
                return;
            }
        }
        for(int i = 1; i <= n; i++){
            if(visit[i]) continue;
            temp.add(i);
            visit[i] = true;
            permutation2(n, k, visit, temp, ret);
            temp.remove(Integer.valueOf(i));
            visit[i] = false;
        }
    }


    /**
     * 找规律：
     *         对于n=4, k=15 找到k=15排列的过程：
     *         1 + 对2,3,4的全排列 (3!个)
     *         2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     *         3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     *         4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)
     *         确定第一位:
     *             k = 14(从0开始计数)
     *             index = k / (n-1)! = 2, 说明第15个数的第一位是3
     *             更新k
     *             k = k - index*(n-1)! = 2
     *         确定第二位:
     *             k = 2
     *             index = k / (n-2)! = 1, 说明第15个数的第二位是2
     *             更新k
     *             k = k - index*(n-2)! = 0
     *         确定第三位:
     *             k = 0
     *             index = k / (n-3)! = 0, 说明第15个数的第三位是1
     *             更新k
     *             k = k - index*(n-3)! = 0
     *         确定第四位:
     *             k = 0
     *             index = k / (n-4)! = 0, 说明第15个数的第四位是4
     *         最终确定n=4时第15个数为3214
     */
    public String getPermutation3(int n, int k) {
        if(n <= 0 || k <= 0) return "";
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        //生成n！
        for(int i = 1; i <= n; i++){
            candidates.add(i);
            factorials[i] = i * factorials[i - 1];
        }
        StringBuilder ret = new StringBuilder();
        k -= 1;//i从0开始，所以k减一
        for(int i = n - 1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            int num = candidates.remove(index);
            ret.append(num);
            k -= index * factorials[i];//或者k %= factorials[i]
        }
        return ret.toString();
    }


}
