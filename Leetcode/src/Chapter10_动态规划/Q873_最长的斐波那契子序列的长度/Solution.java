package Chapter10_动态规划.Q873_最长的斐波那契子序列的长度;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/11/2020 20:29
 **/

public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        Map <Integer,Integer> map = new HashMap <Integer,Integer>();
        int max = 0;
        //将数组以value-index形式存入哈希表中，便于查找
        for(int i = 0; i < len; i++){
            map.put(A[i],i);
        }
        //由于第一次往空数组中添加元素时是加3.后续则每次加一
        for(int i =0; i < len ;i ++){
            for(int j =i+1; j < len; j++){
                dp[i][j] = 2;
            }
        }
        for(int i =0; i < len ; i++){
            for(int j = i+1; j < len; j++){
                //检测在0..i之间是否有元素k满足A[i]+A[k] =A[j];
                if(map.containsKey(A[j] - A[i])){
                    //dp[i][j] = max(dp[i][j], dp[k][i]+1)
                    dp[i][j] = Math.max(dp[i][j], dp[map.get(A[j] - A[i])][i]+1);
                    max = Math.max(max,dp[i][j]);
                }

            }
        }
        return max;
    }
}
