package Chapter0_其他.Q280_摆动排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/01/2021 19:36
 **/

public class Solution {
    /**
     * 摆动排序的目的是重新排列数组
     * 使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for(int i = 0; i < nums.length - 1; i++){
            //这里less表示索引的奇偶性,true表示奇数索引,false表示偶数索引
            if(less){
                if(nums[i] > nums[i+1]){
                    swap(nums,i,i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            //奇偶性翻转
            less = !less;
        }
    }
    public void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
