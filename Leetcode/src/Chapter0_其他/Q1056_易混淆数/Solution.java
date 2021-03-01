package Chapter0_其他.Q1056_易混淆数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/03/2021 22:36
 **/

public class Solution {
    /**
     * 求出当前这个数字的对应的易混淆数字,前后不相等就是true
     * @param N
     * @return
     */
    public boolean confusingNumber(int N) {
        Set <Integer> set = new HashSet(Arrays.asList(0,1,9,8,6));
        int rotated = 0;
        int origin = N;
        while(N > 0){
            int num = N % 10;
            N = N /10;
            if(!set.contains(num)){
                return false;
            }
            if(num == 9){
                num = 6;
            }else if(num == 6){
                num = 9;
            }
            rotated = rotated * 10 + num;
        }
        return rotated !=  origin;
    }
}
