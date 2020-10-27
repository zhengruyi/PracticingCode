package Chapter10_动态规划.Q509_斐波那契数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/10/2020 22:19
 **/

public class Solution {
    public int fib(int N) {
        if(N == 0){
            return 0;
        }
        int prev = 0;
        int curr = 1;
        int sum = 1;
        for(int i = 2; i <= N; i++){
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return sum;
    }
}
