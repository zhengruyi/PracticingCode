package Chapter8_贪心算法.Q252_会议室;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/12/2020 23:51
 **/

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //按照结束时间进行升序排列,要想尽可能在有限长的时间段内安排最多的会议
        //那么久希望会议结束在越早越好
        Arrays.sort(intervals,(o1, o2) -> o1[1] - o2[1]);
        for(int i = 1;i < intervals.length; i++){
            //存在会议冲突
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
