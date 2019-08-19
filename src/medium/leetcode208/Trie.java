package medium.leetcode208;

/**
 * 实现 Trie (前缀树):
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */

/**
 * Trie树：
 * 又名字典树，它的值存储在树的路径上，而普通的树的值都是存储在节点上
 */
public class Trie {

     //Trie树的节点
     class TrieNode{

        //nexts数组，初始化容量为26，分别表示当前节点到下一个节点的分支(path)上的字母和下一个节点的映射
         //索引为26个字母（0 ~ 25），值为下一个节点TrieNode
        private TrieNode[] nexts;

        //是否是一个单词的结尾，如apple，e映射的节点是单词的结尾，此时isWordEnd = true
        private boolean isWordEnd;

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
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 插入一个单词到Trie树
     * 1、从Trie树的根节点root开始，查看word的每个字母c是否在root的nexts数组中
     * 2、如果c在，当前节点直接移动到c映射节点，即下一个节点
     * 3、如果c不在，把它放入nexts数组中，当前节点再移动到c映射节点，即下一个节点
     * 4、当插入一个单词完毕后，要把单词最后一个字母映射的节点的isWordEnd赋值为true，表示该节点是某个单词的结尾
     */
    public void insert(String word) {
        TrieNode curNode = root;
        char[] words = word.toCharArray();
        for(int i = 0; i < words.length; i++){
            char c = words[i];
            if(!curNode.isContainsKey(c)){
                curNode.put(c, new TrieNode());
            }
            curNode = curNode.get(c);
        }
        curNode.isWordEnd = true;
    }

    /**
     * 查看单词是否在Trie树中
     * 和startsWith()不同的是，还需要判断给定的word是否是单词的前缀
     * 必须是完整的单词才能返回true，如insert apple，传入app，返回false，传入apple才返回true
     */
    public boolean search(String word) {
        TrieNode node = searchWord(word);
        return node != null && node.isWordEnd;
    }

    /**
     * 查看某个单词的前缀是否在Trie树中
     * 直接调用searchWord()就行，如insert apple，传入app，返回true
     */
    public boolean startsWith(String prefix) {
        return searchWord(prefix) != null;
    }

    /**
     * 查看word是否在Trie树中
     * 如果还没有遍历完word，就表示word不在Trie树中
     * 返回TrieNode有两种情况：1、给定单词前缀在Trie树中；2、给定单词在Trie树中
     * @return 返回null表示不在，返回TrieNode表示在
     */
    private TrieNode searchWord(String word){
        if(word == null || word.length() == 0) return null;
        TrieNode curNode = root;
        char[] words = word.toCharArray();
        for(int i = 0; i < words.length; i++){
            char c = words[i];
            if(curNode.isContainsKey(c)){
                curNode = curNode.get(c);
            }else {
                return null;
            }
        }
        return curNode;
    }

}
