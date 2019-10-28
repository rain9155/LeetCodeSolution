package medium.leetcode386;

import java.util.LinkedList;
import java.util.List;

/**
 * 字典序排数:
 *
 */
public class Solution {

    /**
     * dfs：
     * 例如求[1, 20]得字典序：
     * 1 10 11 12 13 14 15 16 17 18 19 2 20 3 4 5 6 7 8 9
     * 记遍历当当前数为k，可以发现规律，先排k，然后排k * 10, k * 10 + 1, ..., ,  k * 10 + 9, 才到排k + 1， (k + 1)* 10, ... , (k + 1)* 10 + 9,以此类推
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new LinkedList<>();
        if(n < 1) return ret;
        lexicalOrder(0, n, ret);
        return ret;
    }

    private void lexicalOrder(int k, int n, List<Integer> ret){
        if(k > n) return;
        if(k != 0) ret.add(k);
        for(int i = 0; i <= 9; i++){
            if(k * 10 + i > 0){
                lexicalOrder(k * 10 + i, n, ret);
            }
        }
    }

}
