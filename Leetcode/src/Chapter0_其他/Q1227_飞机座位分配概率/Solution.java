package Chapter0_其他.Q1227_飞机座位分配概率;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/02/2021 23:37
 **/

public class Solution {
    /**
     * 具体的概率推导在这：https://leetcode-cn.com/problems/airplane-seat-assignment-probability/solution/zui-xiang-xi-zheng-ming-yi-bu-bu-tui-dao-gao-su-ni/
     *
     * @param n
     * @return
     */
    public double nthPersonGetsNthSeat(int n) {
        return n >= 2 ? 0.5 : 1;
    }
}
