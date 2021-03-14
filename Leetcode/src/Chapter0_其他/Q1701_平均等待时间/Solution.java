package Chapter0_其他.Q1701_平均等待时间;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/03/2021 22:07
 **/

public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long start = 0;
        long sum = 0;
        for(int i = 0; i < customers.length; i++){
            //上次结束的时间和当前时间哪个较大，取最大值是真正开始做菜的时间
            start = Math.max(customers[i][0],start);
            //菜结束的时间
            start += customers[i][1];
            //统计这道菜花掉的时间
            sum +=  start - customers[i][0];
        }
        //统计做菜的平均时间
        return sum * 1.0 / customers.length;
    }
}
