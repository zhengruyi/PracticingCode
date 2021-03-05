package Chapter0_其他.Q1503_所有蚂蚁掉下来前的最后一刻;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/03/2021 23:32
 **/

public class Solution {
    /**
     * 蚂蚁相遇掉头,其实只是相当于蚂蚁们互相交换名字,其余的都不变,所以其实就是计算蚂蚁
     * 在这个方向上需要多久才能掉下去
     * @param n
     * @param left
     * @param right
     * @return
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for(int i = 0; i < left.length; i++){
            res = Math.max(res,left[i]);
        }
        for(int i = 0; i < right.length; i++){
            res = Math.max(res, n - right[i]);
        }
        return res;
    }
}
