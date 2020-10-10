package Chapter3_分治法.Q2_快速排序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/07/2020 16:52
 **/

public class QuickSort {
    public static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int threshold = nums[low];
            int end = high;
            int start = low;
            while (end >start){
                while (nums[end] >= threshold &&  end > start){
                    end --;
                }
                if(end > start){
                    nums[start] = nums[end];
                    start++;
                }
                while (nums[start] <= threshold && end > start){
                    start++;
                }
                if(end > start){
                    nums[end] = nums[start];
                    end--;
                }
            }
            nums[start] = threshold;
            quickSort(nums,low,start);
            quickSort(nums,start+1,high);
        }


    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,45,3,42,324,342,121,123,12};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
