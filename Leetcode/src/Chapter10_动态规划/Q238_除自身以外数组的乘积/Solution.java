package Chapter10_动态规划.Q238_除自身以外数组的乘积;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/11/2020 16:45
 **/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0){
            return res;
        }
        res[0] = 1;
        //先计算从左往右的前缀积
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] *  nums[i-1];
        }
        int right = 1;
        //由于num[i]表示从0...i-1的乘积，所以只需要采用一个变量记录从右往左的乘积就可以方便计算出
        //除当前元素外的整个数组的乘积
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right *= nums[i];
        }
        return res;
    }
}
