package Chapter3二分查找.Q623_平方数之和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:55
 **/

public class Solution {
    /**
     * 重点就是才用二分搜索来在0..c - a^2之间进行二分搜索，看看能否找到一个数b
     * 满足 a^2 + b^2 == c
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for(long a = 0; c - a * a >= 0; a++){
            if(binarySearch(c-a * a)){
                return true;
            }
        }
        return false;
    }

    /**
     * 简单的二分搜索，去检查一个数字是否存在
     * @param target
     * @return
     */
    public boolean binarySearch(long target){
        long left = 0;
        long right = target;
        while(left <= right){
            long mid = left + (right - left) /2;
            if(mid * mid == target){
                return true;
            }else if(mid * mid < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
