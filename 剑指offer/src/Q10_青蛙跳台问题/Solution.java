package Q10_青蛙跳台问题;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/01/2021 21:55
 **/

public class Solution {
    /**
     * 简单的斐波那契数列
     * @param n
     * @return
     */
    public int numWays(int n) {
        int ans = 0;
        int mod = 1_000_000_000 + 7;
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 1;
        }else{
            int i = 2;
            int p1 = 1;
            int p2 = 1;
            while(i <= n){
                ans = p1 + p2;
                i++;
                ans = ans % mod;
                p2 = p1;
                p1 = ans;
            }
            return ans;
        }
    }
}
