package Chapter10_动态规划.Q887_鸡蛋掉落;

import java.util.HashMap;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/11/2020 22:08
 **/

public class Solution {
    /**
     * 备忘录优化
     */
    HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
    public int superEggDrop(int K, int N) {
        return dp(K,N);
    }
    public int dp(int K, int N){
        //当不要在检测楼层时，则直接返回0
        if(N == 0){
            return 0;
            //当只剩下一鸡蛋时，只能从低到高一层一层测试
        }else if(K == 1){
            return N;
        }else{
            int key = N*100 + K;
            //检查结果是否已经被计算过
            if(map.containsKey(key)){
                return map.get(key);
            }
            // dp[K][N] = 1<=j<=N min(max(dp[K-1][j-1],dp[K][N-j])+1
            //由于随着j增大,dp[k-1][j-1]会递增，而dp[K-1][N-j]会减小，而其中最大值的最小为
            // x0 使得 dp[k-1][j-1] < dp[K-1][N-j] 或者x1使得 dp[k-1][j-1] > dp[K-1][N-j]
            //可以用二分搜索法来确定x0的值，然后计算x1 = x0+1,因为x1和x0都是离散的值
            int lo = 1;
            int hi = N;
            while(lo + 1 < hi){
                int x = (lo+hi)/2;
                int t1 = dp(K-1,x-1);
                int t2 = dp(K,N-x);
                if(t1 < t2){
                    lo = x;
                }else if ( t1 > t2){
                    hi = x;
                }else{
                    hi = lo = x;
                }
            }
            int ans  = 1 + Math.min(Math.max(dp(K-1,lo-1),dp(K,N-lo)),Math.max(dp(K-1,hi-1),dp(K,N-hi)));
            map.put(key,ans);
            return ans;
        }
    }
}
