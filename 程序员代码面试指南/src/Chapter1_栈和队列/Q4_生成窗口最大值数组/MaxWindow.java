package Chapter1_栈和队列.Q4_生成窗口最大值数组;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/05/2020 17:58
 **/

public class MaxWindow {
    static int max = Integer.MIN_VALUE;
    static int index = -1;
    Deque <Integer> deque;

    public int[] getWindowMaxNumber(int[] nums, int width) {
        deque = new ArrayDeque <>(width);
        int[] result = new int[nums.length - width + 1];
        for (int i = 0; i < nums.length; i++) {
            if(i >= width -1){
                result[i - width + 1] = getMax(i,nums,width);
            }else{
                getMax(i,nums,width);
            }
        }
        return result;
    }

    public int getMax(int location, int[] nums, int width) {
        if(deque.isEmpty()){
            deque.addLast(nums[location]);
            return Integer.MIN_VALUE;
        }
        if(deque.peek() == location - width){
            deque.removeFirst();
        }
        boolean flag = true;
        while (flag){
            if(deque.isEmpty()){
                flag = false;
                deque.addLast(location);
            }else if(nums[deque.getLast()] > nums[location]){
                deque.addLast(location);
                flag = false;
            }else{
                deque.removeLast();
            }
        }
        return nums[deque.getFirst()];
    }

    @Test
    void test() {
        int[] nums = {4, 3, 5, 4, 3, 3, 6, 7};
        int width = 3;
        int[] result = getWindowMaxNumber(nums, width);
        Assertions.assertEquals(5, result[0]);
        Assertions.assertEquals(5, result[1]);
        Assertions.assertEquals(5, result[2]);
        Assertions.assertEquals(4, result[3]);
        Assertions.assertEquals(6, result[4]);
        Assertions.assertEquals(7, result[5]);
    }
}
