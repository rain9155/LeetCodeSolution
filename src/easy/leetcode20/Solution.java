package easy.leetcode20;

import java.util.*;

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
     * 遇到左括号则压入栈，遇到右括号则与栈顶元素匹配，若匹配成功则将栈顶元素弹出，最后如果整个栈为空则字符串有效
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

    /**
     * 栈 + 哈希表：O(n)
     * 使用哈希表提前建立左右括号的映射，key为左括号，value为右括号
     * 遍历字符串，如果哈希表的key包含当前遍历的字符，说明为左括号，入栈
     * 否则说明为右括号，这时取出栈顶的左括号为key，从哈希表获取对应右括号看是否和当前遍历的字符匹配
     * 若不匹配返回false，若匹配成功则将栈顶元素弹出，最后如果整个栈为空则字符串有效
     */
    public boolean isValid2(String s) {
        if(s == null) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.add(c);
            }else {
                if(stack.empty() || map.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
