package medium.leetcode117;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针 II:
 * 给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Solution {

    public class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;
        
        public Node() {}
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    
    }

    /**
     * 递归(层次遍历)：
     * 在递归中用一个list保存当前层的结点，如果当前层结点还没有放入list中，就放入，如果当前层list中已经有了该层的结点，就取出把该结点的next指向目前结点，然后更新该结点
     */
    public Node connect(Node root) {
        if(root == null) return null;
        connect(root, 0, new ArrayList<>());
        return root;
    }

    private void  connect(Node root, int lever, List<Node> list) {
        if(root == null) return;
        if(list.size() == lever){
            //保存当层的结点
            list.add(root);
        }else {
            Node preNode = list.get(lever);
            preNode.next = root;
            //更新当前层结点
            list.set(lever, root);
        }
        connect(root.left, lever + 1, list);
        connect(root.right, lever + 1, list);
    }

}
