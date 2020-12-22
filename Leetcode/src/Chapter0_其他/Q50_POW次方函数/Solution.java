package Chapter0_其他.Q50_POW次方函数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:23
 **/

public class Solution {
    /**
     * 快速幂计算方法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        int times = 1;
        boolean isNegative = n < 0;
        n = Math.abs(n);
        return isNegative ? 1/dfs(x,n) : dfs(x,n);
    }
    public double dfs(double x, int n){
        if(n == 0){
            return 1.0;
        }
        if(n == 1){
            return x;
        }
        //如果是偶数那么闲平方在计算，结果的n/2次方
        if(n % 2 == 0){
            return dfs(x * x, n/2);
        }else{
            //如果是奇数次幂，那么就需要计算n/2后在乘上x
            return dfs(x * x, n/2) * x;
        }
    }
}
