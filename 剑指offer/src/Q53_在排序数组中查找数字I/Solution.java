package Q53_在排序数组中查找数字I;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 16/02/2021 23:16
 **/

public class Solution {
    /**
     * 通过二分法找到数组元素的左边界,然后从left开始统计元素个数,
     * 直到遇到第一个不是target的元素,然后返回出现次数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        int res = 0;
        for(int i = left; i < nums.length; i++){
            if(nums[i] == target){
                res++;
            }else{
                return res;
            }
        }
        return res;
    }
}
