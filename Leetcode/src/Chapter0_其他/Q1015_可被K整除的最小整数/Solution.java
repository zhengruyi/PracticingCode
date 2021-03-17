package Chapter0_其他.Q1015_可被K整除的最小整数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/03/2021 23:43
 **/

public class Solution {
    /**
     * 复杂的数学推导 https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/solution/javajie-fa-yi-ji-zheng-ming-de-si-lu-by-jiangzk/
     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        //陷入死循环,直接返回
        if(k % 2 == 0|| k % 5 == 0){
            return -1;
        }
        int temp = 1;
        int len = 1;
        while(temp % k != 0){
            temp = temp * 10 + 1;
            len ++;
            //防止溢出的方法
            temp = temp % k;
        }
        return len;
    }
}
