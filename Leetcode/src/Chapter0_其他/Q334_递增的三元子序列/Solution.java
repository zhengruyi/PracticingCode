package Chapter0_其他.Q334_递增的三元子序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/01/2021 23:34
 **/

public class Solution {
    /**
     * 使用扑克牌堆的方法，求出最大递增子序列长度，然后判断最大递增子序列长度是否大于3
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int piles = 0;
        for(int i = 0; i < nums.length; i++){
            int poker = nums[i];
            int left = 0;
            int right = piles;
            while(left < right){
                int mid = left + (right - left)/2;
                if(arr[mid] < poker){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(left == piles){
                piles++;
            }
            arr[left] = poker;
        }
        return piles >= 3;
    }
}
