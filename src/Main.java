import common.Sorts;
import common.Utils;
import easy.leetcode268.Solution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
                1, 3, 6, 6, 0, 1, 3, 9, 1, 5, 5
        };
        System.out.println("排序前：");
        Utils.printNums(nums);
        System.out.println("排序后：");
        Sorts.mergeSort(nums);
        Utils.printNums(nums);
    }
}
