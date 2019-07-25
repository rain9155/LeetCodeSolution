import medium.leetcode139.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(solution.wordBreak("leetcode", list));
    }
}
