package Chapter0_其他.Q75_颜色分类;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/12/2020 22:43
 **/

public class Solution {
    public void sortColors(int[] nums) {
        //quickSort(nums,0,nums.length - 1);
        numSort(nums);
    }

    /**
     * 快速排序结果
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums, int start, int end){
        if(start > end){
            return;
        }
        int threshold = nums[start];
        int left =start;
        int right = end;
        while(left < right){
            while(nums[right] > threshold && left < right){
                right--;
            }
            if(left < right){
                nums[left] = nums[right];
                left++;
            }
            while(nums[left] < threshold && left < right){
                left++;
            }
            if(left < right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = threshold;
        quickSort(nums,start,left-1);
        quickSort(nums,left+1, end);
    }

    /**
     * 统计排序
     * @param nums
     */
    public void numSort(int[] nums){
        int i0 =0;
        int i1 = 0;
        int i2 = 0;
        for(int i : nums){
            if(i == 0){
                i0++;
            }else if(i == 1){
                i1++;
            }else{
                i2++;
            }
        }
        int index = 0;
        while(i0 != 0 || i1 != 0 || i2 != 0){
            if(i0 > 0){
                nums[index++] = 0;
                i0--;
            }else if(i1 > 0){
                nums[index++] = 1;
                i1--;
            }else{
                nums[index++] = 2;
                i2--;
            }
        }
    }
}
