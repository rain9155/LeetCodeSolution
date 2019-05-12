import common.ListHelper;
import easy.leetcode21.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListHelper helper = new ListHelper();
        int nums[] = {};
        int nums2[] = {1};
        helper.printList(solution.mergeTwoLists2(helper.initList(nums), helper.initList(nums2)));

    }


}
