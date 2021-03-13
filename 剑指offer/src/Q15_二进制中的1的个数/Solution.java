package Q15_二进制中的1的个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 23:24
 **/

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n = n & (n-1);
        }
        return res;
    }
}
