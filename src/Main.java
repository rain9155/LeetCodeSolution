import common.ListHelper;
import medium.leetcode24.Solution;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListHelper listHelper = new ListHelper();
        int[] nums = {1, 2};
        listHelper.printList(solution.swapPairs(listHelper.initList(nums)));

    }


}
