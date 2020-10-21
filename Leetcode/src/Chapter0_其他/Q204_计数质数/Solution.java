package Chapter0_其他.Q204_计数质数;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/10/2020 18:21
 **/

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] mark = new boolean[n];
        Arrays.fill(mark, true);
        //最小搜索范围为sqrt(n);
        for (int i = 2; i * i < n; i++) {
            if (mark[i]) {
                //防止重复计算， j = i*i开始计数
                for (int j = i * i; j < n; j += i) {
                    mark[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (mark[i]) {
                count++;
            }
        }
        return count;
    }
}
