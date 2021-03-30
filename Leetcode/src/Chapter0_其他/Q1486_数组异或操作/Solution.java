package Chapter0_其他.Q1486_数组异或操作;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/03/2021 10:51
 **/

public class Solution {
    /**
     * 简单的异或计算
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n; i++){
            res ^= (2 * i + start);
        }
        return res;
    }
}
