package Chapter1_栈和队列.Q1_如何仅用递归函数和栈操作逆序一个栈;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/05/2020 21:14
 **/

public class Reverse {
    public int getAndRemoveLastElement(Stack<Integer> stack){
        if(stack.isEmpty()) {
            throw new RuntimeException();
        }
        int temp = stack.pop();
        if(stack.isEmpty()){
            return temp;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(temp);
        return last;
    }

    public void reverse(Stack<Integer> stack){
        if(stack == null){
            throw new RuntimeException();
        }
        if(stack.isEmpty()){
            return;
        }
        int temp = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(temp);
    }
    @Test
    void test(){
        Stack<Integer> stack = new Stack <>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        Assertions.assertEquals(1,stack.pop());
        Assertions.assertEquals(2,stack.pop());
        Assertions.assertEquals(3,stack.pop());

    }
}
