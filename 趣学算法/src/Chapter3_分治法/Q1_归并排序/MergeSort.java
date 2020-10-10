package Chapter3_分治法.Q1_归并排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/07/2020 16:32
 **/

public class MergeSort {
    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }

    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int i = low; int j = mid +1;
        int[] temp = new int[high - low +1];
        int k = 0;
        while (i<=  mid && j <= high){
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while (i<= mid){
            temp[k++] = nums[i++];
        }
        while (j<= high){
            temp[k++] = nums[j++];
        }
        for(i = low, k = 0; i<= high; i++){
            nums[i] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,43,54,232,134,32,32};
        mergeSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
