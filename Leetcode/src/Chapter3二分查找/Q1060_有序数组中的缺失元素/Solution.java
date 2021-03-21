package Chapter3二分查找.Q1060_有序数组中的缺失元素;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/03/2021 23:31
 **/

public class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        //如果要求的元素个数大于数组中总体的缺失个数,那么直接在后面往后数
        if(k > missing(n-1,nums)){
            return nums[n-1] + k - missing(n-1,nums);
        }
        //二分搜索找到符合要求的最左边节点
        int left = 0, right = n - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(missing(mid,nums) < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left-1] + k - missing(left-1, nums);
    }
    public int missing(int index, int[]nums){
        //前面是到当前索引位置应该有的连续元素个数减去实际的元素个数等于空缺的元素个数
        return (nums[index] - nums[0] + 1) - (index + 1);
    }
}
