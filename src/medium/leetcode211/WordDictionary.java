package medium.leetcode211;

import medium.leetcode208.Trie;

/**
 * 添加与搜索单词 - 数据结构设计:
 * 设计一个支持以下两种操作的数据结构：
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * 说明:
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */

/**
 * 数据结构使用字典树：参考208题
 */
public class WordDictionary {


    //Trie树的节点
    class TrieNode{

        TrieNode[] nexts;
        boolean isWordEnd;

        public TrieNode(){
            nexts = new TrieNode[26];
        }

        public boolean isContainsKey(char c){
            return nexts[c - 'a'] != null;
        }

        public void put(char c, TrieNode trieNode){
            nexts[c - 'a'] = trieNode;
        }

        public TrieNode get(char c){
            return nexts[c - 'a'];
        }

    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * 往字典树中添加单词
     */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode curNode = root;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(!curNode.isContainsKey(c))
                curNode.put(c, new TrieNode());
            curNode = curNode.get(c);
        }
        curNode.isWordEnd = true;
    }

   /**
    * 从字典树中查询单词
    */
    public boolean search(String word) {
       return search(root, word);
    }

    /**
     * 从root节点开始查询单词：
     * 1、如果匹配到不是'.'，就 curNode = curNode.get(c)，定位到该匹配的字符映射的节点，继续循环匹配；
     * 2、如果是'.'，就要遍历当前结点的所有next[i]，去递归匹配，
     *       2.1、这些next[i]中只要有一个匹配成功就返回true，那么就查询完成，
     *       2.2、否则返回false，继续查询next[i]的下一个，直到所有next[i]查询完毕都没有查询完成的，就返回false，那么就查询失败
     */
    private boolean search(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode curNode = root;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c != '.'){
                if(!curNode.isContainsKey(c))
                    return false;
                curNode = curNode.get(c);
            }else {
                TrieNode[] nexts = curNode.nexts;
                for(TrieNode nextNode : nexts){
                    if(nextNode != null && search(nextNode, word.substring(i + 1)))
                        return true;
                }
                return false;
            }
        }
        return curNode.isWordEnd;
    }

}
