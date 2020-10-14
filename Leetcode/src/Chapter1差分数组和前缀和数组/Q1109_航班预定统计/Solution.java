package Chapter1差分数组和前缀和数组.Q1109_航班预定统计;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/10/2020 13:02
 * @URL  https://leetcode-cn.com/problems/corporate-flight-bookings/
 **/

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if(bookings == null || n < 0){
            return null;
        }
        int[] diff = new int[n];
        for(int i =0; i < bookings.length; i++){
            diff[bookings[i][0] -1] +=bookings[i][2];
            if(bookings[i][1] < n){
                diff[bookings[i][1]] -= bookings[i][2];
            }
        }
        int[] res = new int[n];
        int tmp = 0;
        for(int i = 0; i < diff.length;i++){
            res[i] = tmp + diff[i];
            tmp = res[i];
        }
        return res;
    }
}
