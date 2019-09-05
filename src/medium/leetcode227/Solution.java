package medium.leetcode227;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 基本计算器 II：
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class Solution {

    /**
     * 符号栈 + 数据栈;
     * 遍历s时先把* 和 /计算，然后把数字入栈，当遍历完所有数字时，
     * 根据符合栈和数据栈再计算+ 和 -
     */
    public int calculate(String s) {
        Stack<Integer> dataStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
             switch (c){
                 case '+':
                     charStack.push('+');
                     break;
                 case '-':
                     charStack.push('-');
                     break;
                 case '*':
                     charStack.push('*');
                     break;
                 case '/':
                     charStack.push('/');
                     break;
                 case ' ':
                     break;
                 default:
                     int pre = i;
                     while ( i < s.length() && s.charAt(i) >= '0') i++;
                     int num = Integer.valueOf(s.substring(pre, i));
                     i--;
                     dataStack.push(num);
                     if(!charStack.isEmpty() && !dataStack.isEmpty()){
                         if(charStack.peek() == '*'){
                             dataStack.push(dataStack.pop() * dataStack.pop());
                             charStack.pop();
                         }else if(charStack.peek() == '/'){
                             int temp = dataStack.pop();
                             dataStack.push(dataStack.pop() / temp);
                             charStack.pop();
                         }
                     }
                     break;
             }

        }
        List<Integer> dataList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        while (!dataStack.isEmpty()){
            dataList.add(dataStack.pop());
        }
        while (!charStack.isEmpty()) {
            charList.add(charStack.pop());
        }
        int ret = dataList.get(dataList.size() - 1);
        for(int i = charList.size() - 1; i >= 0; i--){
            if(charList.get(i) == '+'){
                ret += dataList.get(i);
            }else{
                ret -= dataList.get(i);
            }
        }
        return ret;
    }

}
