package Chapter0_其他.Q57_插入区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:02
 **/

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List <int[]> res = new ArrayList <>();
        int len = intervals.length;
        //检查当前的区间是否是处于newInterval的左边
        while(i < len && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        //由于intervals是按照区间的起始点升序排列的,所以如果区间的起始点在新区间终点的
        //左边，由于所有不相交的区间都已经在前面一个区间遍历过了，所以后续区间的起始点一定在前一个
        //区间的右边,所以后续区间一定会有相交的情况
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        //将所有不相交的右边区间都放入结果队列中
        while(i < len && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
