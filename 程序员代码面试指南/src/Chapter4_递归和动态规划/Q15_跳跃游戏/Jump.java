package Chapter4_递归和动态规划.Q15_跳跃游戏;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/06/2020 18:01
 **/

public class Jump {
    public int jump(int[]arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int cur = 0;
        int next = 0;
        int jump = 0;
        for (int i = 0; i < arr.length; i++) {
            if(cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);
        }
        return jump;
    }
    @Test
    void test(){
        int[] jump = {3,2,3,1,1,4};
        Assertions.assertEquals(2,jump(jump));
    }
}
