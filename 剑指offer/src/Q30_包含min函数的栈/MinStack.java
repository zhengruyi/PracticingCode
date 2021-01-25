package Q30_包含min函数的栈;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/01/2021 23:17
 **/

/**
 * 基本思路就是另外创建一个栈用来持续压入最小值，如果要压入的值比栈顶小
 * 那么就压入当前值否则压入栈顶的值
 */
public class MinStack {
    Stack <Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min.push(min.isEmpty() || x < min.peek() ? x : min.peek());
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
