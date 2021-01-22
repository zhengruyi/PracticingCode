package Chapter0_其他.Q1014_最佳观光组合;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/01/2021 23:34
 **/

public class Solution {
    /**
     * 目标是获得 A[i] +A[j] + i - j 的和最大值，但是由于对于j来说A[j]-j是定值，那么当A[i]+i最大时
     * 整体值最大，所以目标转化成求A[i]+i的最大值
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int max = A[0] + 0;
        for(int j = 1; j < A.length; j++){
            //求全局最大值
            ans = Math.max(ans,max + A[j] - j);
            //更新前面的A[i]+i的最大值
            max = Math.max(max,A[j]+j);
        }
        return ans;
    }
}
