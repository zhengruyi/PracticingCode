package Chapter4_递归和动态规划.Q14_排成一条线的纸牌博弈问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/06/2020 19:38
 **/

public class WinnerScore {
    public int getScore(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(first(arr,0,arr.length-1),second(arr,0,arr.length-1));
    }
    public int first(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i]+second(arr,i+1,j),arr[j]+second(arr,i,j-1));
    }
    public int second(int[] arr, int i, int j){
        if(i==j){
            return 0;
        }
        return Math.min(first(arr,i+1,j),first(arr,i,j-1));
    }

    @Test
    void test(){
        Assertions.assertEquals(101,getScore(new int[]{1,2,100,4}));
        Assertions.assertEquals(100,getScore(new int[]{1,100,2}));
    }
}
