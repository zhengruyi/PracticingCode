package Chapter0_其他.Q961_重复N次的元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 11/02/2021 23:53
 **/

public class Solution {
    /**
     * 由于一个元素的出现次数等于数组的一半,那么连续的两个子序列要么是一个主要元素或者两个主要元素
     * 所以长度为4的连续子序列中必然包含两个主要元素,所以以不同的间隔遍历数组,如果两个位置元素
     * 形同,那么这就是主要元素
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        for(int k = 1; k <= 3; k++){
            for(int i = 0; i < A.length - k; i++){
                if(A[i] == A[i+k]){
                    return A[i];
                }
            }
        }
        return -1;
    }
}
