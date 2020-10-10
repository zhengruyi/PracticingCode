package Algorithm;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 07/09/2019 14:18
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] nums={1,78,5,3,-5,-17,23,6,9,7,34,-18,7};
        nums= quickSort(nums,0,nums.length-1);
        for(int i:nums)
            System.out.println(i);

    }
    private static int[] quickSort(int[] nums, int start, int end){
        if(start>end)
            return nums;
        int pivot=nums[start];
        int i=start;
        int j=end;
        while(i<j){
            while(nums[j]>=pivot&&i<j)
                j--;
            while(nums[i]<=pivot&&i<j)
                i++;

            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[start]=nums[i];
        nums[i]=pivot;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);

        return nums;
    }


}
