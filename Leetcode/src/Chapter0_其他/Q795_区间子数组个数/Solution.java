package Chapter0_其他.Q795_区间子数组个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 08/02/2021 18:17
 **/

public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        //要求所有元素大于等于L,小于等于R,等于count(R) -count(L-1)
        return count(A,R) - count(A,L-1);
    }

    /**
     * 统计A数组中所有元素小于等于target的子数组数目
     * @param A
     * @param target
     * @return
     */
    public int count (int[] A, int target){
        int res = 0;
        int cur = 0;
        for(int num : A){
            //cur的数目就是以num为结尾的子数组的数目
            cur = num <= target ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}
