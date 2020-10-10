package Chapter1_栈和队列.Q7_最大值减去最小值小于等于num的子数组数量;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/05/2020 19:10
 **/

public class SubArrayNumbers {
    public int getSubArrayNumbers(int[] array, int num) {
        int sum = 0;
        int[] position = new int[2];
        for (int i = 0; i < array.length; i++) {
            position[0] = i;
            getPosition(array, position, num);
            sum += position[1] - position[0];
        }
        return sum;
    }

    public void getPosition(int[] array, int[] position, int num) {
        Deque <Integer> max = new ArrayDeque <>();
        Deque <Integer> min = new ArrayDeque <>();
        int end = position[0];
        boolean flag = true;
        while (flag && end < array.length) {
            updateMax(max, array, end);
            updateMin(min, array, end);
            if (!(array[max.getFirst()] - array[min.getFirst()] <= num)) {
                flag = false;
                break;
            }
            end += 1;
        }
        position[1] = end;
    }

    public void updateMax(Deque <Integer> deque, int[] array, int location) {
        if (deque.isEmpty()) {
            deque.addLast(location);
        } else {
            boolean flag = true;
            while (flag) {
                if (deque.isEmpty()) {
                    flag = false;
                    deque.addLast(location);
                } else if (array[deque.getLast()] > array[location]) {
                    flag = false;
                    deque.addLast(location);
                } else {
                    deque.removeLast();
                }
            }
        }
    }

    public void updateMin(Deque <Integer> deque, int[] array, int location) {
        if (deque.isEmpty()) {
            deque.addLast(location);
        } else {
            boolean flag = true;
            while (flag) {
                if (deque.isEmpty()) {
                    flag = false;
                    deque.addLast(location);
                } else if (array[deque.getLast()] < array[location]) {
                    flag = false;
                    deque.addLast(location);
                } else {
                    deque.removeLast();
                }
            }
        }
    }

    @Test
    void test() {
        int[] array = {4, 1, 2, 3};
        Assertions.assertEquals(7, getSubArrayNumbers(array, 2));
        int[] array1 = {1, 2, 3, 4};
        Assertions.assertEquals(9, getSubArrayNumbers(array1, 2));
        int[] array2 = {1, 3, 5, 7, 9};
        Assertions.assertEquals(9, getSubArrayNumbers(array2, 2));

    }
}
