package Chapter8_数组和矩阵问题.Q5_需要排序的最短子数组的长度;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/06/2020 19:44
 **/

public class NoOrderLength {
    public int getLength(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int minNoindex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] < min){
                min = arr[i];
            }else if(arr[i] > min){
                minNoindex = i;
            }
        }
        if ( minNoindex == -1){
            return 0;
        }
        int maxNoindex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >max){
                max = arr[i];
            }else if(arr[i] < max){
                maxNoindex = i;
            }
        }
        return maxNoindex - minNoindex +1;
    }

    @Test
    void test(){
        int[] nums = {1,5,3,4,2,6,7};
        Assertions.assertEquals(4,getLength(nums));
        int[] nums1 = {1,2,3,4};
        Assertions.assertEquals(0,getLength(nums1));
    }
}
