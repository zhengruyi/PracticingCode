package Chapter4_双指针技巧.Q202_快乐数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:50
 **/

public class Solution {
    public boolean isHappy(int n) {
        int fastRunner = getNext(getNext(n));
        int slowRunner = getNext(n);
        //如果是快乐数字，那么快指针会先到达1，如果不是那会成环，慢指针会追到快指针
        while(fastRunner != 1 && fastRunner != slowRunner){
            fastRunner = getNext(getNext(fastRunner));
            slowRunner = getNext(slowRunner);
        }
        if(fastRunner == 1){
            return true;
        }
        return false;
    }
    public int getNext(int n ){
        int totalSum = 0;
        while(n > 0){
            int d = n %10;
            n = n/10;
            totalSum += d*d;
        }
        return totalSum;
    }
}
