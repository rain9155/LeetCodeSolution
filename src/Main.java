import common.Utils;
import medium.leetcode210.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{0, 1}};
        Utils.printNums(solution.findOrder2(2, nums));
    }
}
