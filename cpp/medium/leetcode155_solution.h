#pragma once
#include <stack>

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
namespace Leetcode155
{
    /**
     * 使用辅助栈和数据栈，两个栈的数据不同步：
     * 1、push时，数据栈入栈，辅助栈如果为空也入栈，否则判断入栈的元素是否小于辅助栈的栈顶元素，如果是，辅助栈入栈，如果不是，忽略这个入栈元素
     * 2、pop时，数据栈出栈，如果出栈的元素的等于辅助栈的栈顶元素，辅助栈出栈，否则忽略这个出栈元素
     * 3、top时，直接返回数据栈的栈顶元素
     * 4、getMin时，因为辅助栈栈顶元素一直都是最小的元素，直接返回辅助栈的栈顶元素的值就行
     * 原理：由于栈的后进先出，所以如果后面进来的元素比前面的小，那么最小的元素就会保存在辅助栈的栈顶，次小元素在栈顶的后面
     */
    class MinStack 
    {
    public:
        MinStack() 
        {

        }
        
        void push(int val) 
        {
            main_stack_.push(val);
            if(min_stack_.empty() || min_stack_.top() >= val)
            {
                min_stack_.push(val);
            }
        }
        
        void pop()
        {
            int top = this->top();
            main_stack_.pop();
            if(min_stack_.top() == top)
            {
                min_stack_.pop();
            }
        }
        
        int top()
        {
            return main_stack_.top();
        }
        
        int getMin() 
        {
            return min_stack_.top();
        }

    private:
        std::stack<int> main_stack_;
        std::stack<int> min_stack_;
    };
}