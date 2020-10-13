package Chapter6_位运算.Q231_2的幂;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/10/2020 22:14
 **/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        long i =1;
        int index = 0;
        while(index++ < 64){
            if((i ^ n) == 0){
                return true;
            }
            i <<= 1;
        }
        return false;
    }
}
