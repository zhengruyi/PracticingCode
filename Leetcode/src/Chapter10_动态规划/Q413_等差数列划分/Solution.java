package Chapter10_动态规划.Q413_等差数列划分;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 03/11/2020 22:13
 **/

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int sum = 0;
        //这里要尤其注意dp数组定义:以当前A[i]为结尾元素的等差数组比A[i-1]元素结尾
        //的等差数组多出来的等差子数组数目，这个值固定为1，因为只多出一个元素A[i-2]A[i-1]A[i]
        //这样一个子数组,同时注意dp定义，是多出来的差值，所以sum要对dp求和得出的才是最终结果
        int dpMinusOne = 0;
        int dp = 0;
        for(int i = 2;i < A.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp = dpMinusOne +1;
            }else{
                dp =0;
            }
            sum+=dp;
            dpMinusOne = dp;
        }
        return sum;
    }
}
