package Chapter0_其他.Q912_排序数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/03/2021 22:35
 **/

public class Solution {
    /**
     * 填坑法快排
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums, int start, int end){
        if(start > end){
            return;
        }
        int threshold = nums[start];
        int j = end;
        int i = start;
        while(i < j){
            while(i < j && nums[j] > threshold){
                j--;
            }
            if(i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] < threshold){
                i++;
            }
            if(i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = threshold;
        quickSort(nums,start,i - 1);
        quickSort(nums,i+1, end);
    }
}
