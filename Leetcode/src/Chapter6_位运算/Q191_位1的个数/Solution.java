package Chapter6_位运算.Q191_位1的个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/10/2020 22:12
 **/

public class Solution {
    /**
     * n&(n-1) 相当于把数字n的最后一位数字1变成0
     */

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n = n & (n-1);
        }
        return res;
    }
}
