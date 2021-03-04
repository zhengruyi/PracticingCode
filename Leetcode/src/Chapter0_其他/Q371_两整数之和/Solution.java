package Chapter0_其他.Q371_两整数之和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/03/2021 23:21
 **/

public class Solution {
    /**
     * a ^ b的结果时是无进位加法的计算结果
     * (a & b) << 1的结算结果就是进位的值
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        //这里 b != 0是因为b可能是负数,所以循环结束的条件是 b == 0
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
