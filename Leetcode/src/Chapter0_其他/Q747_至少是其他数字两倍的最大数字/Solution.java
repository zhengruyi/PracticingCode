package Chapter0_其他.Q747_至少是其他数字两倍的最大数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 29/12/2020 20:54
 **/

public class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        //第一次遍历，获取最大值，同时获取最大值的下标
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                index = i;
                max = nums[i];
            }
        }
        //检查该值是否至少是其他元素的两倍，不是返回-1
        for(int i = 0; i < nums.length; i++){
            if(i == index){
                continue;
            }
            if(max < nums[i] * 2){
                return -1;
            }
        }
        return index;
    }
}
