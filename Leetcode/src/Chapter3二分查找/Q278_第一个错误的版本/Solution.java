package Chapter3二分查找.Q278_第一个错误的版本;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/12/2020 22:55
 **/

public class Solution {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            //这里的isBadVersion由leetcode提供，用来判断版本是否错误
            //使用二分搜索来最大化的减少查询次数
            if(!isBadVersion(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public boolean isBadVersion(int n){
        return false;
    }
}
