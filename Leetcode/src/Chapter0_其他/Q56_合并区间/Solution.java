package Chapter0_其他.Q56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/10/2020 15:46
 **/

public class Solution {
    public int[][] merge(int[][] intervals) {
        //根据数组元素中的第一个数字进行升序排列
        Arrays.sort(intervals, new Comparator <int[]>(){
            @Override
            public int compare(int[] t1, int[] t2){
                return t1[0] - t2[0];
            }
        });
        int len = intervals.length;
        List <int[]> list = new ArrayList <int[]>();
        for(int i= 0; i < len;){
            //进行区间合并
            int[] tmp = new int[2];
            tmp[0] = intervals[i][0];
            int end = intervals[i][1];
            while(i < len - 1 && end >= intervals[i+1][0]){
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            tmp[1] = end;
            list.add(tmp);
            i++;
        }
        int[][] res = new int[list.size()][2];
        for( int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
