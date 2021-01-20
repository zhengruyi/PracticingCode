package Chapter0_其他.Q1131_绝对值表达式的最大值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 20/01/2021 22:04
 **/

public class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        //因为绝对值的缘故，总共有四个方向
        int[][] offset = {{1,1},{1,-1},{-1,-1},{-1,1}};
        int ans = 0;
        for(int i = 0; i < offset.length; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < arr1.length; j++){
                //统计四个方向上的最大值和最小值
                max = Math.max(max, arr1[j] * offset[i][0] + arr2[j] * offset[i][1] + j);
                min = Math.min(min, arr1[j] * offset[i][0] + arr2[j] * offset[i][1] + j);
            }
            //更新最大值
            ans = Math.max(ans,max - min);
        }
        return ans;
    }
}
