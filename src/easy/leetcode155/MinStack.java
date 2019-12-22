package easy.leetcode155;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

/**
 * 最小栈：
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

/**
 * 使用辅助栈和数据栈，两个栈的数据不同步：
 * 1、push时，数据栈入栈，辅助栈如果为空也入栈，否则判断入栈的元素是否小于辅助栈的栈顶元素，如果是，辅助栈入栈，如果不是，忽略这个入栈元素
 * 2、pop时，数据栈出栈，如果出栈的元素的等于辅助栈的栈顶元素，辅助栈出栈，否则忽略这个出栈元素
 * 3、top时，直接返回数据栈的栈顶元素
 * 4、getMin时，因为辅助栈栈顶元素一直都是最小的元素，直接返回辅助栈的栈顶元素的值就行
 * 原理：由于栈的后进先出，所以如果后面进来的元素比前面的小，那么最小的元素就会保存在辅助栈的栈顶，次小元素在栈顶的后面
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(helper.isEmpty() || helper.peek() >= x){
            helper.add(x);
        }
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        int num = stack.pop();
        if(num == helper.pop()) helper.pop();
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(helper.isEmpty())
            return -1;
        return helper.peek();
    }

}

//使用单个栈,参考：https://github.com/azl397985856/leetcode/blob/master/problems/155.min-stack.md
//栈内保存的入栈的元素值和这个元素入栈时的最小值之差
//push时：入栈元素与min做差（入栈元素 - min）放入栈顶，入栈后，如果入栈的元素值小于min，则更新当前最小值min为入栈的元素值
//pop时：如果栈顶元素 > 0, 返回（栈顶元素 + min）; 否则返回min，并更新min = （min - 栈顶元素）
//getMin时：直接返回min
