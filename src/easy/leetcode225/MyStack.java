package easy.leetcode225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈:
 *
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * 使用两个队列实现:
 * 使用两个队列queue1，queue2，queue1用来保存插入的元素，queue2辅助栈，再用一个top变量保存栈顶元素，除了pop，使得queue2为空
 * push：直接往queue1中插入元素，然后更新top变量
 * pop：queue1中的最后一个元素即栈顶元素，所以把queue1中的元素放入queue2，直到queue1中只剩下一个元素，返回这个元素，然后再交换queue1和queue2，使得queue2保持为空，queue1为pop出一个元素后的队列
 * top：直接返回top
 * empty：判断queue1是否为空
 */
public class MyStack {

    Queue<Integer> queue1, queue2;
    int top;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) return -1;
        while (queue1.size() != 1){
            top = queue1.poll();
            queue2.add(top);
        }
        int poll = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poll;
    }

    /** Get the top element. */
    public int top() {
        if(empty()) return -1;
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}

//使用队列实现方式2：
//同样使用两个队列queue1，queue2，但不使用top变量保存栈顶元素，queue2还是辅助栈，除了push，保持queue2为空
//在push时，往queue2中插入元素，然后把queue1中的元素逐个放入queue2，这样queue2的第一个元素就是栈顶元素，然后再交换queue1和queue2，使得queue2保持为空，queue1为push一个元素后的队列
//对于pop，top，直接返回queue1的第一个元素，对于empty，判断queue1就行

