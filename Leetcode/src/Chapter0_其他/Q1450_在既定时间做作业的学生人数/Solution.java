package Chapter0_其他.Q1450_在既定时间做作业的学生人数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/01/2021 23:02
 **/

public class Solution {
    /**
     * 简单搜索就行，可以采用树状数组来加块访问
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i = 0; i < startTime.length; i++){
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
