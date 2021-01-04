package Chapter15_面试题.Q0803_魔术索引;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 04/01/2021 20:58
 **/

public class Solution {
    /**
     * 如果所有元素都不重复，那么可以根据nums[i]-i来判断目标在当前左边还是右边
     * 这样的时间复杂是o(logn),但是存在中父元素时则只能用分治的思想，最坏的情况下
     * 时间复杂度是o(n)
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        return getAnswer(nums,0,nums.length - 1);
    }
    public int getAnswer(int[] nums, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left)/2;
        //求左半部分是否有正确的结果，因为有多个结果时要返回最左边的那个索引
        int leftAnswer = getAnswer(nums,left,mid-1);
        //左边有符合要求的结果，则返回
        if(leftAnswer != -1){
            return leftAnswer;
            //左边没有符合要求,检查中间节点是否符合
        }else if(nums[mid] == mid){
            return mid;
        }else{
            //右边是否存在符合要求的节点
            return getAnswer(nums,mid+1, right);
        }
    }
}
