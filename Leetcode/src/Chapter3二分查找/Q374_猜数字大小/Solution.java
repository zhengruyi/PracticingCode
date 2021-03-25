package Chapter3二分查找.Q374_猜数字大小;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/03/2021 23:40
 **/

public class Solution {
    /**
     * 简单的二分搜索
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            int offset = guess(mid);
            if( offset == 0){
                return mid;
            }else if(offset > 0){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int guess(int x){
        return  0;
    }
}
