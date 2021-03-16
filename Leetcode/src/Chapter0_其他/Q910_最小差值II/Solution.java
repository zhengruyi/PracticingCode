package Chapter0_其他.Q910_最小差值II;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/03/2021 21:32
 **/

public class Solution {
    /**
     * 总的来说思路就是将数组排序后,先计算原来的最小和最大的差别,要缩小两者之间的差别
     * 必然是数组分成两部分一部分加上K,另外一部分减去K,那么最大值的来源可能是A[i]+k,或者A[n-1] - k
     * 而最小值的可能来源是A[i+1] - k 或者 A[0] + k，取最大值的最小值之间的差就是答案
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII(int[] A, int K) {
        int len = A.length;
        Arrays.sort(A);
        //在初始状况下的最小和最大的值的差别
        int res = A[len - 1] - A[0];
        //切分位置有多个可能,所以挨个遍历可能的位置
        for(int i = 0; i < len - 1; i++){
            //计算更新后的最大值和最小值,更新答案
            int high = Math.max(A[i] + K, A[len - 1] - K);
            int low = Math.min(A[i+1] - K, A[0] + K);
            res = Math.min(res,high - low);
        }
        return res;
    }
}
