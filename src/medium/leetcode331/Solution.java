package medium.leetcode331;

import java.util.Stack;

/**
 * 验证二叉树的前序序列化:
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class Solution {


    /**
     * 递归：
     * 模仿二叉树的前序遍历，如果preorder可以从根节点开始前序遍历完毕，则preorder为合法的二叉树前序序列化，否则不是
     */
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        if(preorder.charAt(0) == '#' && preorder.length() == 1) return true;
        if(preorder.length() < 5) return false;
        String[] chars = preorder.split(",");
        return isValidSerialization(chars, 0) == chars.length;
    }

    private int isValidSerialization(String[] preorder, int index){
        if(index >= preorder.length) return -1;
        if("#".equals(preorder[index])) return 1;
        int left = isValidSerialization(preorder, index + 1);
        if(left == -1){
            return -1;
        }
        int right = isValidSerialization(preorder, index + left + 1);
        if(right == -1){
            return -1;
        }
        return left + right + 1;
    }

}
