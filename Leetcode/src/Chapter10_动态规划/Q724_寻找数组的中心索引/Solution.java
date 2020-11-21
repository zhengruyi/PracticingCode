package Chapter10_动态规划.Q724_寻找数组的中心索引;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/11/2020 16:52
 **/

public class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        //记录从左往右的前缀和
        for(int i = 1; i< nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        //记录从右往左的前缀和
        for(int j = nums.length -2; j>=0; j--){
            rightSum[j] = rightSum[j+1] + nums[j+1];
        }
        //如果如果一个元素的左边元素和右边元素前缀和相等，那么就是中心索引
        for(int i =0; i < nums.length; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}
