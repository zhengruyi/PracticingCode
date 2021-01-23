package Chapter0_其他.Q1313_解压缩编码列表;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/01/2021 21:23
 **/

public class Solution {
    /**
     * 简单的for循环
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i+= 2){
            sum += nums[i];
        }
        int[] res = new int[sum];
        int index = 0;
        for(int i = 0; i < nums.length; i+= 2){
            for(int j = 0; j < nums[i]; j++){
                res[index++] = nums[i+1];
            }
        }
        return res;
    }
}
