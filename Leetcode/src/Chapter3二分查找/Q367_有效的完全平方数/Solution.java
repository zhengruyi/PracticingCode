package Chapter3二分查找.Q367_有效的完全平方数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/02/2021 23:27
 **/

public class Solution {
    /**
     * 简单的二分搜索，需要注意因为中间会有结果想乘，那么就需要把数据转化成long
     * 这样就避免了溢出的问题
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right){
            long mid = left + (right - left) /2;
            long tmp = mid * mid;
            if(tmp == num){
                return true;
            }else if(tmp < num){
                left = (int)(mid + 1);
            }else{
                right = (int)(mid - 1);
            }
        }
        return false;
    }
}
