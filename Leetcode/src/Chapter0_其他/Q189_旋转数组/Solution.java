package Chapter0_其他.Q189_旋转数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/12/2020 22:19
 **/

public class Solution {
    /**
     * 旋转的过程就是先全部旋转，然后根据k旋转前k位
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }
    public void swap(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
