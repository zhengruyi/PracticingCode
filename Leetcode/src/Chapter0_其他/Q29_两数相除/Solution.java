package Chapter0_其他.Q29_两数相除;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/12/2020 22:08
 **/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 1){
            return dividend;
        }
        //根据题意,Integer.MIN_VALUE/-1 会溢出，所以要返回Integer.MAX_VALUE
        if(divisor == -1){
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        //判断是否要加负号
        boolean isNegative = (dividend < 0 ^ divisor < 0);
        //把所有元素都转化成负数计算来避免溢出问题
        divisor = divisor < 0 ? divisor : - divisor;
        dividend = dividend < 0 ? dividend : -dividend;
        int res = div(dividend, divisor);
        return isNegative ? -res : res;
    }
    public int div(int dividend, int divisor){
        if(dividend > divisor){
            return 0;
        }
        //采用二分法来加速求取过程
        int tmp = divisor;
        int count = 1;
        //为防止两个负数过大，相加溢出所以添加了tmp + tmp < 0的判断,由于tmp 和dividend都是负数所以
        //正常是tmp * 2 > dividend
        while(tmp + tmp < 0 && tmp + tmp > dividend){
            tmp += tmp;
            count+= count;
        }
        //由于都是负数所以减去是dividend - tmp
        return count + div(dividend - tmp, divisor);
    }
}
