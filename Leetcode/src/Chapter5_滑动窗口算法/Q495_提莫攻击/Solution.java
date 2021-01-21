package Chapter5_滑动窗口算法.Q495_提莫攻击;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:08
 **/

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }else if(timeSeries.length == 1){
            return duration;
        }
        int left = 0;
        int sum = 0;
        int right = 1;
        while(right < timeSeries.length){
            //如果间隔超过duration,那么就需要单独计算left .. right -1 + duration的时间长度
            if (timeSeries[right] - timeSeries[right - 1] > duration) {
                //累加中毒时间
                sum += (timeSeries[right - 1] - timeSeries[left]) + duration;
                //更新左边界
                left = right;
            }
            right++;
        }
        //末尾防止漏数据再次更新中毒事件
        sum += (timeSeries[right - 1] - timeSeries[left]) + duration;
        return sum;
    }
}
