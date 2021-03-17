package Chapter0_其他.Q1344_时钟指针的夹角;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/03/2021 23:27
 **/

public class Solution {
    /**
     * 就是简单的计算主要考虑时针分针的位置关系，注意绝对值的关系
     * @param hour
     * @param minutes
     * @return
     */
    public double angleClock(int hour, int minutes) {
        double minuteDegree = minutes * 6;
        hour = hour % 12;
        double hourDegree = (hour + minutes * 1.0 / 60) * 30;
        double res = Math.abs(minuteDegree - hourDegree);
        return Math.min(res, 360 - res);
    }
}
