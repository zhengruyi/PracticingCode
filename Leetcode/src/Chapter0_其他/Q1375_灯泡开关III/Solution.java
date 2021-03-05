package Chapter0_其他.Q1375_灯泡开关III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:26
 **/

public class Solution {
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int num = 1;
        int max = 0;
        /**
         * 如果当前已经打开的最大灯泡编号和已经打开的灯泡数目相等,那么就说明,
         * 之前所有的灯泡都已经打开了就计数一次
         */
        for(int i = 0; i < light.length; i++){
            max = Math.max(max,light[i]);
            if(max == num){
                res++;
            }
            num++;
        }
        return res;
    }
}
