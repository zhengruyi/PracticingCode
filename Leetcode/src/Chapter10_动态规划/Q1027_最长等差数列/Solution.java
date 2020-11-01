package Chapter10_动态规划.Q1027_最长等差数列;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/11/2020 20:36
 **/

public class Solution {
    public int longestArithSeqLength(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len][len];
        //等差数列长度最小为2，因为任意数组中的两个元素都可以构成等差数列
        int max = 2;
        Map <Integer,Integer> map = new HashMap <>(A.length);
        //第一次往数组添加元素时，数组长度增加3，其后每次增加1
        for(int i =0; i < len; i++){
            for(int j= i +1; j < len ;j++){
                dp[i][j] = 2;
            }
        }
        for(int i =0; i < len; i++){
            for(int j =i +1; j < len ; j++){
                //这里是一个窍门，可以解决不知到等差数列是增大还是减小的问题
                int target = 2 * A[i] - A[j];
                if(map.containsKey(target)){
                    dp[i][j] = Math.max(dp[i][j],dp[map.get(target)][i] +1);
                    max = Math.max(max,dp[i][j]);
                }
            }
            //由于数组中可能存在重复元素，所以边遍历边添加
            map.put(A[i],i);
        }
        return max;
    }
}
