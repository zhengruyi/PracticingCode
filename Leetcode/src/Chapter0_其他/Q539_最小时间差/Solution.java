package Chapter0_其他.Q539_最小时间差;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:29
 **/

public class Solution {
    public int findMinDifference(List <String> timePoints) {
        //每天最多有1440分钟，超过这个数字就是,最小时间差就是0
        if(timePoints.size() > 1440){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[] minutes = new int[timePoints.size()];
        for(int i = 0;i < timePoints.size();i++){
            String s = timePoints.get(i);
            //将时间转化成分钟
            minutes[i] = Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3,5));
        }
        //排序
        Arrays.sort(minutes);
        //求出元素的两两之差，求取最小值
        for(int i = 1; i < minutes.length; i++){
            min = Math.min(min,minutes[i] - minutes[i-1]);
        }
        //最后考虑23:59 - 00:00这样收尾相连的情况
        min = Math.min(min, 1440 - minutes[minutes.length -1] + minutes[0]);
        return min;
    }
}
