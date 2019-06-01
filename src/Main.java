import common.Utils;
import common.struction.ListNode;
import medium.leetcode61.Solution;
import common.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List list = new List();
        ListNode head = list.initList(new int[]{1, 2, 3});
        list.printList(head);
        list.printList(solution.rotateRight(head, 7));
    }
}
