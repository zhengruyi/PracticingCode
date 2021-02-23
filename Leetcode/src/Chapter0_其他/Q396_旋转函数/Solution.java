package Chapter0_其他.Q396_旋转函数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/02/2021 23:21
 **/

public class Solution {
    /**
     * 根据递推公式可知 f(k+1) = f(k) + sum - len * num[len-1]
     * 具体的递推方法是错位相减
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int len = A.length;
        int sum = 0;
        int prev = 0;
        //求出初始值和数组的和
        for(int i = 0; i < len; i++){
            sum += A[i];
            prev += i * A[i];
        }
        int max = prev;
        int curr = 0;
        //地推公式计算全部的值
        for(int i = 0; i < len; i++){
            curr = prev + sum - len  * A[len - i -1];
            max = Math.max(max,curr);
            prev = curr;
        }
        return max;
    }
}
