package medium.leetcode385;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 迷你语法分析器:
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 提示：你可以假定这些字符串都是格式良好的：
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9, [, - ,, ]
 *  
 * 示例 1：
 * 给定 s = "324",
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 示例 2：
 * 给定 s = "[123,[456,[789]]]",
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个 integer 包含值 789
 */
public class Solution {

    public NestedInteger deserialize(String s) {
        if(s.length() == 0) return new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                stack.push(new NestedInteger(c));
            }else if(c == ']'){
                LinkedList<NestedInteger> list = new LinkedList<>();

                while (!stack.isEmpty()){

                    NestedInteger nestedInteger = stack.pop();

                    if(nestedInteger.getInteger() == '['){//这个nestedInteger是'['

                        NestedInteger tempNestedInteger = new NestedInteger();

                        if(list.size() > 0){
                            for(NestedInteger n : list){
                                tempNestedInteger.add(n);
                            }
                        }

                        stack.push(tempNestedInteger);

                        break;

                    }else {//这个nestedInteger是一个列表或一个数字

                        list.addFirst(nestedInteger);

                    }
                }
            }else{

                int start = i;
                while (i < s.length()){
                    if(s.charAt(i) == ']' || s.charAt(i) == ','){
                        break;
                    }
                    i++;
                }

                String s1 = s.substring(start, i);

                stack.push(new NestedInteger(
                        Integer.valueOf(s1)
                ));

                if(i < s.length() && s.charAt(i) == ']'){
                    i--;
                }
            }
        }
        return stack.pop();
    }


    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){}

        // Constructor initializes a single integer.
        public NestedInteger(int value){}

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){return 0;}

        public void setInteger(int value){}

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){}

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        public List<NestedInteger> getList(){return  null;}
    }

}
