package Q16_栈的压入和弹出序列;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/05/2020 10:30
 **/

public class CheckStackOrder {
    public boolean check(int[] origin, int[] order){
        if(origin.length != order.length){
            return false;
        }

        if(origin.length == 1 || origin.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack <>();
        int index = 0;
        //尽可能把数组元素都装入栈中
        for (int i = 0; i < origin.length; i++) {
            if(!stack.isEmpty() && stack.peek() == order[index]){
                stack.pop();
                index++;
            }
            stack.push(origin[i]);
        }
        // 进行挨个匹配来确认是否是弹出序列
        while (!stack.isEmpty() && stack.peek() == order[index]){
            stack.pop();
            index++;
        }
        return stack.isEmpty();
    }
    @Test
    void test(){
        int[] origin = {1,2,3,4,5};
        int[] correct = {4,5,3,2,1};
        int[] wrong = {4,3,5,1,2};
        assertTrue(check(origin,correct));
        assertFalse(check(origin,wrong));
    }
}
