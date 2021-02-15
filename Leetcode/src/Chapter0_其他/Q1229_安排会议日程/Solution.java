package Chapter0_其他.Q1229_安排会议日程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/02/2021 21:45
 **/

public class Solution {
    public List <Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        //按照开始时间排序
        Arrays.sort(slots1,(a, b) -> a[0] - b[0]);
        Arrays.sort(slots2,(a,b) -> a[0] - b[0]);
        int len1 = slots1.length;
        int len2 = slots2.length;
        //表示检索到slots1和slots2对应的哪些位置
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            //两个时间段没有交区间则直接跳过
            if(slots1[i][0] > slots2[j][1]){
                ++j;
                continue;
            }else if(slots2[j][0] > slots1[i][1]){
                ++i;
                continue;
            }
            //检查相交的区间段是否大于duration
            if(Math.min(slots1[i][1],slots2[j][1]) - Math.max(slots1[i][0],slots2[j][0]) >= duration){
                //返回结果
                int start = Math.max(slots1[i][0],slots2[j][0]);
                return Arrays.asList(start,start + duration);
            }
            //终点较低的那个时间段递进
            if(slots1[i][1] > slots2[j][1]){
                ++j;
            }else{
                ++i;
            }
        }
        //找不到符合要求的时间段,返回空的列表
        return new ArrayList <>();
    }
}
