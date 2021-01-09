package Chapter5_滑动窗口算法.Q1004_最大的连续的1的个数III;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 00:04
 **/

public class Solution {
    public int longestOnes(int[] A, int K) {
        int num = 0;
        int left = 0;
        int right = 0;
        /**
         * 基本思路思路就是窗口的单向扩大,当窗口长度减去窗口中1的个数小于等于k时
         * 可以将窗口中的0替换成1来，那么最长的连续1的个数就是窗口长度,但如果大于k急需要移动左边界
         * 这样最后返回的窗口长度就是最后的连续1个数
         */
        for(; right < A.length; right++){
            if(A[right] == 1){
                num++;
            }
            //不满足条件，移动左边界
            if((right - left + 1) - num > K){
                if(A[left] == 1){
                    num--;
                }
                left++;
            }
        }
        return right - left;
    }
}
