package Chapter3二分查找.Q69_x的平方根;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/12/2020 23:30
 **/

public class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int left = 1;
        int right = x;
        //由于x1 > x2,则x1^2 > x2^2，所以存在单调性，所以可以用二分搜索来做
        while(left < right){
            long mid = left + (right - left)/2;
            if(mid * mid < x){
                left = (int)(mid+1);
            }else if( mid * mid == x){
                return (int)mid;
            }else{
                right = (int)(mid);
            }
        }
        return left -1;
    }
}
