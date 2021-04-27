/**
 * @author zhucheng
 * @create 2021-04-27-9:49
 */
package easy.stack;

import java.util.Stack;

//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈
// 👍 45 👎 0
public class 面试题0302_栈的最小值 {
    class MinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.isEmpty()){
                stack2.push(x);
            }else if (stack2.peek() >= x){
                stack2.push(x);
            }
        }

        public void pop() {
            if(stack1.peek().equals(stack2.peek())){  //对象和对象比较要使用equals
                stack1.pop();
                stack2.pop();
            }else {
                stack1.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
