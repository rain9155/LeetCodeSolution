package easy.leetcode20;

import java.util.Stack;

/**
 * 有效的括号:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合
 * 2、左括号必须以正确的顺序闭合
 * 3、注意空字符串可被认为是有效字符串
 */
public class Solution {


    /**
     * 利用栈的性质，先进后出: O(n)
     * 遇到左括号则压入栈，
     * 遇到右括号则与栈顶元素匹配，若匹配成功则将栈顶元素弹
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            switch (c){
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '['){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

}
