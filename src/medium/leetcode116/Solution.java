package medium.leetcode116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针:
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
     * 非递归 + 使用队列(使用了额外的空间)：
     * 使用队列保存逐层的结点，然后按层把结点连起来就行
     */
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if(i != size - 1) node.next = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

        }
        return root;
    }


    /**
     * 递归( 不使用额外的空间)：
     * 按层遍历，每次从最左边的结点开始，记为curNode,先把curNode的左右结点连起来
     * 如果curNode有next结点，就把curNode的右结点和curNode的next结点的左结点连起来
     */
    public Node connect2(Node root) {
        if(root == null) return null;
        Node curNode = root;
        while (curNode != null){
            if(curNode.left != null){
                curNode.left.next = curNode.right;
            }
            if(curNode.right != null && curNode.next != null){
                curNode.right.next = curNode.next.left;
            }
            curNode = curNode.next;
        }
        connect2(root.left);
        return root;
    }

}
