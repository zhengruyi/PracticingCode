package Chapter12_数组和字符串.Q56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/11/2020 22:34
 **/

public class Solution {
    public int[][] merge(int[][] intervals) {
        //排序规则:按左边界从小到大排列，如果左边界相等，那么就按照右边界从小到大排列
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        ArrayList <int[]> list = new ArrayList<int[]>();
        int index = 0;
        while(index < intervals.length){
            int[]tmp = new int[2];
            //记录区间左边界
            tmp[0] = intervals[index][0];
            int end = index;
            while(index+ 1 < intervals.length && intervals[end][1] >= intervals[index+1][0] ){
                //寻找区间的右边界
                if(intervals[end][1] > intervals[index+1][1]){
                    index++;
                }else{
                    index++;
                    end = index;
                }
            }
            tmp[1] = intervals[end][1];
            index++;
            list.add(tmp);
        }
        int[][] res = new int[list.size()][2];
        for(int i =0; i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
