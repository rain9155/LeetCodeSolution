package medium.leetcode241;

import java.util.ArrayList;
import java.util.List;

/**
 * 为运算表达式设计优先级:
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Solution {

    /**
     * 分治算法：
     * 1、把input表达式根据运算符划分为左右子表达式
     * 2、分别对左右子表达式递归1步骤，直到子表达式只剩下一个数字
     * 3、当递归返回时，根据左右子表达式的返回结果算出当前运算符的所有组合结果
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input.length() == 0){
            return res;
        }
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(!isDigital(c)){
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1, input.length()));
                for(Integer num1 : res1){
                    for(Integer num2 : res2){
                        if(c == '+'){
                            res.add(num1 + num2);
                        }else if(c == '-'){
                            res.add(num1 - num2);
                        }else if(c == '*'){
                            res.add(num1 * num2);
                        }
                    }
                }
            }
        }
        //input中只有一个数字
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    private boolean isDigital(char c){
        return c >= '0' && c <= '9';
    }

}
