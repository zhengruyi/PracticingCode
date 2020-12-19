package Q51_数组中的逆序对;

import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/12/2020 00:19
 **/

public class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] temp = new int[nums.length];
        //归并排序
        mergerAndCounter(nums,0,nums.length-1,temp);
        return count;
    }
    public void mergerAndCounter(int[] nums, int left, int right, int[] temp){
        if(left == right){
            return;
        }
        int mid = left+(right - left)/2;
        mergerAndCounter(nums, left,mid,temp);
        mergerAndCounter(nums,mid+1, right,temp);
        //归并优化，如果两个子数组已经有序就不需要在合并，并且也不会存在逆序对
        if(nums[mid] <= nums[mid+1]){
            return;
        }
        //合并有序数组，同时计算逆序对数目
        counter(nums,left,mid,right,temp);

    }
    public void counter(int[] nums, int left, int mid, int right, int[] temp){
        for(int i = left; i <= right;i++){
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid+1;
        for(int k = left; k <= right;k++){
            if(i > mid){
                nums[k] = temp[j];
                j++;
            }else if(j > right){
                nums[k] = temp[i];
                i++;
                count +=(right - mid);
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
                count += (j-mid - 1);
            }else{
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
