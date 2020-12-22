package Chapter0_其他.Q313_超级丑数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:36
 **/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n];
        //这里存储堆顶的质数要和dp表的那个数字相同
        int[] index = new int[len];
        //初始值为1
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            //选取全局最小值
            for(int j = 0; j < len; j++){
                if(primes[j] * dp[index[j]] < min){
                    min = primes[j] * dp[index[j]];
                }

            }
            //更新dp表
            dp[i] = min;
            //跟新索引，注意这里采用遍历的方式是因为可能会出现丑数计算重复的问题，所以采用遍历来更新
            //避免了重复统计的问题
            for (int j = 0; j < len; j++) {
                if (min == primes[j] * dp[index[j]]) {
                    index[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
