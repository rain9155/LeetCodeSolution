package medium.leetcode127;

import javafx.util.Pair;

import java.util.*;

/**
 * 单词接龙:
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Solution {

    /**
     * 广度优先遍历：标准广度优先搜索的终止条件就是找到结束单词。
     * 把wordList的每个和beginWord看作一张图中的每个结点，因为每次转换只能改变一个字母，所以如果结点与结点之间只有一个字母不一样，就把这两个结点连起来，这样就形成了一张图
     * 把找beginWord到endWord的最短转换序列的长度就变成了找从beginWord结点开始到endWord结点结束的最短路径
     * 算法：
     * 1、对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在commonStatusWordDict中，键就是每个结点的通用状态，值就是相邻结点集合
     * 2、将包含 beginWord 和 1 的Pair放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
     * 3、为了防止出现环，使用visitDict记录已经访问过的结点。
     * 4、当队列中有元素的时候，取出第一个元素，记为 pair。
     * 5、找到 pair 中记录的结点，记为word， 找出word的所有通用状态，并遍历这些通用状态是否存在其它单词的映射，这一步通过检查commonStatusWordDict来实现。
     * 6、根据通用状态从commonStatusWordDict获得的所有单词，都是和word相邻的结点
     * 7、然后遍历和word相邻的结点，如果该相邻结点等于目标endWord，返回lever + 1，如果该相邻结点不等于目标endWord，且没有访问过就把它的lever + 1并加入队列
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLen = beginWord.length();
        Map<String, List<String>> commonStatusWordDict = new HashMap<>();//wordList的每个单词的所有通用状态与每个单词的映射, 键就是每个结点的通用状态，值就是相邻结点集合
        //遍历wordList，对每个单词进行状态转化，即用一个*代替单词中的某个字母
        wordList.forEach(word -> {
            for(int i = 0; i < wordLen; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                List<String> adjacentList = commonStatusWordDict.getOrDefault(newWord, new ArrayList<>());
                adjacentList.add(word);
                commonStatusWordDict.put(newWord, adjacentList);
            }
        });
        Queue<Pair<String , Integer>> queue = new LinkedList<>();//用一个Pair保存图的每层结点和当前层的层数
        queue.add(new Pair<>(beginWord, 1));
        Map<String, Boolean> visitDict = new HashMap<>();//记录结点是否访问过
        //广度优先遍历图的每一层结点
        while (!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            int lever = pair.getValue();
            visitDict.put(word, true);
            for(int i = 0; i < wordLen; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                //遍历当前结点的所有相邻结点
                for(String adjacentWord : commonStatusWordDict.getOrDefault(newWord, new ArrayList<>())){
                    //如果该相邻结点等于目标endWord，返回lever + 1
                    if(adjacentWord.equals(endWord)){
                        return lever + 1;
                    }
                    //如果该相邻结点不等于目标endWord，且没有访问过
                    if(!visitDict.containsKey(adjacentWord)){
                        queue.add(new Pair<>(adjacentWord, lever + 1));
                    }
                }
            }
        }
        return 0;
    }

}
