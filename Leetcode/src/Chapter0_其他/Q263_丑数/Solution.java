package Chapter0_其他.Q263_丑数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/02/2021 23:54
 **/

public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        //就是检查是否数字只是有2,3,5乘积构成的不是就不是丑数
        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
            }else if(num % 3 == 0){
                num /= 3;
            }else if(num % 5 == 0){
                num /= 5;
            }else{
                return false;
            }
        }
        return true;
    }
}
