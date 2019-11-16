package medium.leetcode406;

import java.util.*;

/**
 * 根据身高重建队列:
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution {

    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，如果H相同，按K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     * 核心思想：
     * 假设候选队列为 A，已经站好队的队列为 B.
     * 从 A 里挑身高最高的人 x 出来，插入到 B. 因为 B 中每个人的身高都比 x 要高，
     * 因此 x 插入的位置，就是看 x 前面应该有多少人就行了。比如 x 前面有 5 个人，那 x 就插入到队列 B 的第 5 个位置。
     */
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people[0].length == 0) return new int[0][0];

        //先把people按照身高降序排序，如果身高相同，k值大的排后面
        //这样排序后的people就是身高越高的排前面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        //接着从头开始遍历，按照k插入到另外一个队列中
        List<int[]> list = new LinkedList<>();
        for(int[] pair : people){
            list.add(pair[1], pair);
        }


        return list.toArray(new int[people.length][2]);
    }

}
