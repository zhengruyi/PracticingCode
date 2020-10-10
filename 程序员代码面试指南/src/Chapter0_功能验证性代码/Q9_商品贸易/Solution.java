package Chapter0_功能验证性代码.Q9_商品贸易;

import java.util.Stack;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/07/2020 20:31
 **/

public class Solution {
    public static void calculate(int n, int[] nums){

        int res1 = 0, res2 = 0;
        long sum = 0;

        for(int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1])
            {
                sum += nums[i] - nums[i - 1];
                res1 += res2 ^ 1;
                //当res = 0时，表示当前手上没有股票，由于今天比昨天价格高，所以昨天买入，交易一次
                res2 = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                // 今天价格比昨天低，如果有股票，则应在昨天卖出，没有则无所谓
                res1 += res2;
                res2 = 0;
            }
        }
        System.out.println(sum + " " +(res1 + res2) );
    }
    public static void main(String[] args) {
        calculate(5,new int[]{9,7,10,1,5});
    }
}
