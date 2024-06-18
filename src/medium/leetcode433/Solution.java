
package medium.leetcode433;

import java.util.*;

/**
 * 最小基因变化:
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化，一次基因变化就意味着这个基因序列中的一个字符发生了变化, 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数，如果无法完成此基因变化，返回 -1 。
 * 
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 
 * 示例 1:
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 
 * 示例 2:
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 
 * 示例 3:
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 */
public class Solution {

    /**
     * 广度优先搜索：
     * 可以进行尝试所有合法的基因变换序列，并找到最小的变换次数即可, 步骤如下：
     * 1、如果 start 与 end 相等，此时直接返回 0，如果 end 不在 bank 中，直接返回 −1；
     * 2、每次从基因序列中变换一个字符，尝试所有可能的基因变换序列，基因序列变换一次最多可能会生成 3×8=24 种不同的基因序列, 变换规则如下
     *      2.1：序列 A 与 序列 B 之间只有一个字符不同；
     *      2.2: 变化字符只能从 ‘A’, ‘C’, ‘G’, ‘T’ 中进行选择；
     *      2.3: 变换后的序列 B 一定要在字符串数组 bank 中；
     * 3、检测当前变换一个字符生成的基因序列的合法性，当前变换生成的基因序列需要在数组 bank 中并且未遍历过，如果合法则将其加入到队列中；
     * 4、如果当前变换生成的基因序列与 end 相等，则此时直接返回最小的变化次数即可，如果队列中所有的元素都已经遍历完成还无法变成 end，返回 -1；
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> cnt = new HashSet<>();
        if(startGene.equals(endGene)) {
            return 0;
        }
        for(String s : bank) {
            cnt.add(s);
        }
        if(!cnt.contains(endGene)) {
            return -1;
        }
        int step = 1;
        char[] keys = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                //从队列中取出基因序列，对基因序列的每个字符变换一次，总共有 3x8 = 24 种可能的基因变换
                String gene = queue.poll();
                for(int j = 0; j < 8; j++) {
                    for(int k = 0; k < 4; k++) {
                        if(gene.charAt(j) != keys[k]) {
                            StringBuilder nextGenebuilder = new StringBuilder(gene);
                            nextGenebuilder.setCharAt(j, keys[k]);
                            String nextGene = nextGenebuilder.toString();
                            //判断当前变换的基因序列的合法性，当前变换生成的基因序列需要在数组 bank 中并且未遍历过
                            if(!visited.contains(nextGene) && cnt.contains(nextGene)) {
                                if(nextGene.equals(endGene)) {
                                    return step;
                                }else {
                                    queue.add(nextGene);
                                    visited.add(nextGene);
                                }
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
}