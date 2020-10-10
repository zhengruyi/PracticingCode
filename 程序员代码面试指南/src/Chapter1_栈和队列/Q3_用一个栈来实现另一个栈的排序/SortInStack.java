package Chapter1_栈和队列.Q3_用一个栈来实现另一个栈的排序;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/05/2020 10:38
 **/

public class SortInStack {
    public int getMinNumber(Stack<Integer> stack){
        int temp = stack.pop();
        if(stack.isEmpty()){
            return temp;
        }
        int last = getMinNumber(stack);
        if(temp < last){
            stack.push(last);
            return temp;
        }else{
            stack.push(temp);
            return last;
        }
    }
    public void sort(Stack<Integer> stack, Stack<Integer> sortedStack){
        if(stack == null || stack.isEmpty()){
            return;
        }
        int element = getMinNumber(stack);
        sortedStack.push(element);
        sort(stack,sortedStack);
    }

    @Test
    void test(){
        Stack<Integer> s1 = new Stack <>();
        Stack<Integer> s2 = new Stack <>();
        s1.push(1);
        s1.push(7);
        s1.push(3);
        s1.push(4);
        s1.push(2);
        sort(s1,s2);
        Assertions.assertEquals(7,s2.pop());
        Assertions.assertEquals(4,s2.pop());
        Assertions.assertEquals(3,s2.pop());
        Assertions.assertEquals(2,s2.pop());
        Assertions.assertEquals(1,s2.pop());
    }
}
