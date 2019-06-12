package medium.leetcode79;

/**
 * 单词搜索：
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class Solution {

    /**
     * 时间复杂度O(n * m * 4word.length())，其中n = board.length，m = board[0].length：
     * 遍历 + 深度优先遍历：
     * 首先遍历整个board数组,每遇到一个相等的字符时，做深度优先遍历
     * 递归函数要记录一个dist变量，表示当前搜索的深度，或者已经找到的字符串的长度，当dist == word.length -1 的时候，说明已经找到了这个字符串，就可以返回true；
     * 四个方向只需要一个即可，遍历每一个位置，从每个位置开始DFS即可，注意边界的判断，用一个visited数组记录已经访问过的位置，防止重复访问（这里在递归的时候使用board[i][j] = '#'，然后递归，就标识了已经访问了，就省去了一个visited数组，当然也可以使用visited数组）
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        char c = chars[0];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == c && dfs(board, chars, visited, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     */
    private boolean dfs(char[][] board, char[] word, boolean[][] visited, int pos, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[pos] || visited[i][j])
            return false;
        if(pos == word.length - 1)
            return true;
        if(word[pos] == board[i][j])
            pos++;
        visited[i][j] = true;
        boolean result = dfs(board, word, visited,  pos, i, j + 1)
                || dfs(board, word, visited, pos, i + 1, j)
                || dfs(board, word, visited,  pos, i - 1, j)
                || dfs(board, word, visited, pos, i, j - 1);
        visited[i][j] = false;
        return result;
    }

}
