package Q7_用两个栈实现队列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/04/2020 20:24
 **/

public class TwoStackAsQueue {
    Stack<Integer> stack1 = new Stack <>();
    Stack<Integer> stack2 = new Stack <>();

    public void appendTail(int value){
        stack1.push(value);
    }
    public Integer deleteHead(){
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            if(stack2.empty())
                throw new RuntimeException("Queue is emoty");
            else
                return stack2.pop();
        }
        return stack2.pop();
    }

    @Test
    void test() {
        appendTail(3);
        Assertions.assertEquals(java.util.Optional.of(3).get(),deleteHead());
        appendTail(2);
        appendTail(5);
        Assertions.assertEquals(java.util.Optional.of(2).get(),deleteHead());
        deleteHead();
    }
    @Test
    void testException(){
        Assertions.assertThrows(RuntimeException.class,()->deleteHead());
    }
}
