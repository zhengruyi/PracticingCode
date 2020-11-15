package Chapter10_动态规划.Q120_三角形最小路径和;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/11/2020 18:02
 **/

public class Solution {
    public int minimumTotal(List<List <Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int rows = triangle.size();
        int[] dp = new int[rows];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i< rows; i++){
            List<Integer> list = triangle.get(i);
            //为了进行空间压缩，所以需要反向遍历
            for(int j = list.size() -1; j >= 0; j--){
                int t1 = Integer.MAX_VALUE;
                int t2 = Integer.MAX_VALUE;
                if(j - 1 >= 0){
                    t1 = dp[j-1] + list.get(j);
                }
                if(j != list.size() -1){
                    t2 = dp[j] + list.get(j);
                }
                dp[j] = Math.min(t1,t2);
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
