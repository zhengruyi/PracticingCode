package Chapter8_数组和矩阵问题.Q6_在数组中找到出现次数大于K分之N的数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/06/2020 10:16
 **/

public class FindNumber {
    /**
     * 在数组中找到出现次数大于一半的数字
     *
     * @param arr
     * @return
     */
    public int find(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException();
        }
        int times = 0;
        int candidate = 0;

        //找出可能出现次数超过一半的一个数字，但也有可能数组中不存在这个数字
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                candidate = arr[i];
            } else if (arr[i] == candidate) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate){
                times++;
            }
        }
        if(times > arr.length/2){
            return candidate;
        }else{
            throw new RuntimeException();
        }
    }


    @Test
    void test(){
        Assertions.assertEquals(1,find(new int[]{1,1,1,1,2,3,43,532,1}));
    }
}
