import common.Sorts;
import common.Utils;
import medium.leetcode73.Solution;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args){
        int[] nums = new int[]{
                1, 3, 6, 6, 0, 1, 3, 9, 1, 5, 5
        };
        System.out.println("排序前：");
        Utils.printNums(nums);
        System.out.println("排序后：");
        Sorts.bucketSort(nums);
        Utils.printNums(nums);
    }

}
