package Q22_栈的压入和弹出序列;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/04/2020 13:27
 **/

public class PushPopOrder {
    public boolean checkOrder(int[] push, int[] pop) {
        if(push == null || pop == null || push.length == 0 || pop.length ==0)
            return false;
        Stack <Integer> stack = new Stack <>();
        boolean result = false;
        int index_push = 0;
        int index_pop = 0;
        while (index_pop < pop.length) {
            if (stack.empty() || stack.peek() != pop[index_pop]) {
                while (push[index_push] != pop[index_pop]) {
                    stack.push(push[index_push]);
                    if (index_push == push.length - 1)
                        break;
                    else
                        index_push++;
                }
                index_pop++;
                index_push = index_push < push.length-1 ? ++index_push : index_push;
            } else {
                stack.pop();
                index_pop++;
            }
        }
        if (index_pop == pop.length && stack.empty())
            result = true;

        return result;

    }

    @Test
    void test(){
        int[] nums = {1, 2, 3, 4, 5};
        int[] corder = {4, 5, 3, 2, 1};
        int[] forder = {4, 3, 5, 1, 2};
        Assertions.assertTrue(checkOrder(nums,corder));
        Assertions.assertFalse(checkOrder(nums,forder));
        Assertions.assertTrue(checkOrder(nums,new int[]{5,4,3,2,1}));

    }
}
