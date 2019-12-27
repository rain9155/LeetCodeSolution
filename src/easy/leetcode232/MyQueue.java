package easy.leetcode232;

import java.util.Stack;

/**
 * 用栈实现队列：
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */

/**
 * 使用两个栈：
 * 使用两个栈fromStack，toStack，fromStack用来暂时保存元素，当获取元素时，从toStack中获取
 * push: 把元素直接插入fromStack中
 * pop：如果toStack为空，把fromStack的元素移动到toStack中，这样toStack的栈顶元素就是队列的第一个元素， 返回toStack的栈顶元素，如果如果toStack不为空，直接返回toStack的栈顶元素
 * peek：和pop一样，如果toStack为空，把fromStack的元素移动到toStack中，再取出toStack的栈顶元素
 * empty：判断fromStack和toStack是否为空
 */
public class MyQueue {

    Stack<Integer> fromStack;
    Stack<Integer> toStack;

    public MyQueue() {
        fromStack = new Stack<>();
        toStack = new Stack<>();
    }

    public void push(int x) {
        fromStack.push(x);
    }

    public int pop() {
        move();
        return toStack.pop();
    }

    public int peek() {
        move();
        return toStack.peek();
    }

    private void move(){
        if(fromStack.isEmpty() || !toStack.isEmpty()) return;
        while (!fromStack.isEmpty()){
            toStack.push(fromStack.pop());
        }
    }

    public boolean empty() {
        return fromStack.isEmpty() && toStack.isEmpty();
    }

}

// 使用两个栈实现方式2：
// 使用两个栈stack，stackHelper，stack用来保存元素，stackHelper是辅助栈，除了push，stackHelper都保持为空
// 在push时，把stack中的元素放入stackHelper中，然后把要插入的元素放入stack中，然后再把stackHelper中的元素重新返回stack，这样stack中的最后一个元素就是最近进来的元素，栈顶元素就是很久之前进来的元素，符合队列的结构
// 在pop、peek时直接返回stack的栈顶元素，empty时判断stack是否为空就行
