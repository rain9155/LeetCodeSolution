import common.Utils;
import medium.leetcode399.Solution;

import java.util.ArrayList;
import java.util.Optional;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.calcEquation(
                new ArrayList<>(){{
                    add(new ArrayList<>(){{
                        add("a");
                        add("b");
                    }});
                    add(new ArrayList<>(){{
                        add("e");
                        add("f");
                    }});
                    add(new ArrayList<>(){{
                        add("b");
                        add("e");
                    }});
                }},
                new double[]{3.1, 1.4 , 2.3},
                new ArrayList<>(){{
                    add(new ArrayList<>(){{
                        add("a");
                        add("f");
                    }});
                }}
        );
    }
}
