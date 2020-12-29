package Chapter0_其他.Q201_数字范围按位与;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 21:26
 **/

public class Solution {
    /**
     * 范围与的结果就是数字最小值和最大值的最长公共前缀
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        // n &(n-1)会将最后方1变成0,而当n < m时，n就是最长的公共前缀
        while(m < n){
            n = n &(n-1);
        }
        return n;
    }
}
