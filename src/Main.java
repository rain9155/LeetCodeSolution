import common.Utils;
import medium.leetcode189.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Utils.printNums(nums);
        solution.rotate2(nums, 3);
        Utils.printNums(nums);
    }
}
