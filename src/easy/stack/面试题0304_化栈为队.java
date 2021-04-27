/**
 * @author zhucheng
 * @create 2021-04-27-14:10
 */
package easy.stack;

import java.util.Stack;

//实现一个MyQueue类，该类用两个栈来实现一个队列。 示例： MyQueue queue = new MyQueue(); queue.push(1);
//queue.push(2); queue.peek();  // 返回 1 queue.pop();   // 返回 1 queue.empty(); // 返
//回 false 说明： 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty
// 操作是合法的。 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 假设所有操作都是有效的
//（例如，一个空的队列不会调用 pop 或者 peek 操作）。 Related Topics 栈
// 👍 38 👎 0
class 面试题0304_化栈为队 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public 面试题0304_化栈为队() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    //pop操作，只有当stack2为空的时候，才将stack1的元素移到stack2中
    //否则push操作的元素将保存在stack1中，pop操作的是stack2中的元素。
    public int pop() {
        if(stack2.isEmpty()){
            turnStack1ToStack2();
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            turnStack1ToStack2();
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    //将stack1的元素移到stack2中
    private void turnStack1ToStack2(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
