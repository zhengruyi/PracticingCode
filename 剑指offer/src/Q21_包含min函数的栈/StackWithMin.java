package Q21_包含min函数的栈;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 12:48
 **/

public class StackWithMin {
    private Stack <Integer> minStack = new Stack <Integer>();
    private Stack <Integer> baseStack = new Stack <Integer>();
    private int threshold;

    public void push(int num) {
        if (baseStack.empty()) {
            threshold = num;
            minStack.push(num);
            baseStack.push(num);
            return;
        }

        baseStack.push(num);
        if (num < threshold) {
            minStack.push(num);
            threshold = num;
        } else
            minStack.push(threshold);


    }

    public int getMin() {
        return minStack.peek();
    }

    public int pop() {
        minStack.pop();
        return baseStack.pop();
    }

    @Test
    void tes(){
        StackWithMin sw = new StackWithMin();
        sw.push(2);
        sw.push(3);
        sw.push(1);
        Assertions.assertEquals(1,sw.getMin());
        sw.pop();
        Assertions.assertEquals(2,sw.getMin());
        sw.push(-1);
        Assertions.assertEquals(-1,sw.getMin());
    }
}
