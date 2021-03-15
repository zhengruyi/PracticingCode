package Chapter0_其他.Q1749_任意子数组和的绝对值的最大值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/03/2021 22:41
 **/

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res = 0, max = 0, min = 0;
        for(int num : nums){
            //求数组的最大和
            max = Math.max(num, max + num);
            //更新最大值
            res = Math.max(max,res);
            //跟新最小值
            min = Math.min(num, min + num);
            //因为绝对值所以来源可能是最大值或者对最小值取绝对值
            res = Math.max(res,Math.abs(min));
        }
        return res;
    }
}
