package Chapter0_其他.Q1288_删除被覆盖区间;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/03/2021 23:06
 **/

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        //排序规则,先按数组的第一个元素从小到大排序,再按数组的第二个元素从大到小排列
        Arrays.sort(intervals,(o1, o2) ->{
            if(o1[0] == o2[0]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int res = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            //被上一个区间包含,去除1
            if(left <= intervals[i][0] && intervals[i][1] <= right){
                res --;
            }else{
                //由于不考虑区间和并,那么重新更新更新区间信息，因为区间的右端点已经不同了
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return res;
    }
}
