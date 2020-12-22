package Chapter5_滑动窗口算法.Q1031_两个非重叠子数组的最大和;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/12/2020 23:08
 **/

public class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for(int i = 1; i < A.length; i++){
            A[i] += A[i-1];
        }
        //初始值，两个窗口靠在一起
        int res  = A[L+M-1];
        //初始值，从0..L-1
        int maxL = A[L-1];
        //初始值 从0..M-1
        int maxM = A[M-1];
        for(int i = L+M; i < A.length; i++){
            //从i-M .. i-L-M 选取长度为L的最大值,后半段为长度为M的窗口
            maxL = Math.max(maxL, A[i-M] - A[i-L-M]);
            //从i-L.. i-L-M 选取长度为L的最大值,后半段为长度为L的窗口
            maxM = Math.max(maxM, A[i-L] - A[i-L-M]);
            //计算两种情况下的和的最大值
            res = Math.max(res, Math.max(maxM + A[i] - A[i-L],maxL+A[i]-A[i-M]));
        }
        return res;
    }
}
