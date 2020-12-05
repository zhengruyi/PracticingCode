package Chapter12_数组和字符串.Q70_爬楼梯;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/12/2020 20:14
 **/

public class Solution {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if( n == 2){
            return 2;
        }else{
            int Minus1 = 2;
            int Minus2 = 1;
            int res = 0;
            for(int i = 3; i <= n; i++){
                res = Minus1 + Minus2;
                Minus2 = Minus1;
                Minus1 = res;
            }
            return res;
        }
    }
}
