package Chapter10_动态规划.Q801_使序列递增的最小交换次数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/11/2020 23:00
 **/

public class Solution {
    public int minSwap(int[] A, int[] B) {
        if(A.length == 0){
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len][len];
        //表示首位不交换
        int dpMinus00 = 0;
        //表示首位交换
        int dpMinus01 = 1;
        int dp00 = 0;;
        int dp01 = 0;;
        for(int i = 1; i < len; i++){
            //序列递增，且有交叉，则第i位元素可以交换，也可以不交换
            if(A[i-1] < A[i] && B[i-1] < B[i]){
                if(A[i-1] < B[i] && B[i-1] < A[i]){
                    //不发生交换
                    dp00 = Math.min(dpMinus00,dpMinus01);
                    //发生交换
                    dp01 = Math.min(dpMinus00,dpMinus01) +1;
                }else{
                    //序列处于递增状态，但没有交叉，此时交换i位时也需要交换第i-1位
                    //不交换i位时，就不交换i-1位
                    dp00 = dpMinus00;
                    dp01 = dpMinus01 + 1;
                }
                //序列不是递增则必须交换
            }else{
                //此时可以交换i-1位或者交换i位，但是不可以都交换
                //交换i-1位
                dp00 = dpMinus01;
                //交换第i位
                dp01 = dpMinus00 + 1;
            }
            dpMinus00 = dp00;
            dpMinus01 = dp01;
        }
        return Math.min(dp00,dp01);
    }
}
