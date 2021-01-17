package Chapter3二分查找.Q162_寻找峰值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:15
 **/

public class Solution {
    /**
     * 对于峰值的定义是 num[i] > num[i+1] && num[i] > num[i-1]
     * 这题由于边界处num[-1]和nums[n]都算负无穷大，所以这里可以根据大值所在的方向
     * 来进行二分搜索
      * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //由于这里保证一定有一个峰值所以left == right时不用考虑

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
