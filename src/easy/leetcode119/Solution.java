package easy.leetcode119;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II:
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Solution {

    /**
     * 找规律：
     * 这里依旧使用杨辉三角的规律，很隐藏的规律：对于杨辉三角的同一行，第 ( i + 1) 项是第 i 项的 ( k - i ) /( i + 1 ) 倍。
     * 比如：
     * 第 k 索引行的第 0 项：1
     * 第 k 索引行的第 1 项：1 * k
     * 第 k 索引行的第 2 项：1 * k * ( k - 1) / 2
     * 第 k 索引行的第 3 项：[1 * k * ( k - 1) / 2 ] * ( k - 2 ) / 3
     * 所以：index = index * (rowIndex - i) / (i + 1)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>(rowIndex + 1);
        long index = 1;//防止溢出
        for(int i = 0; i <= rowIndex; i++){
            ret.add((int)index);
            index = index * (rowIndex - i) / (i + 1);
        }
        return ret;
    }

}
