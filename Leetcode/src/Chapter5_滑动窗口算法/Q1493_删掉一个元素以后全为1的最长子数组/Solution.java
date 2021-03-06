package Chapter5_滑动窗口算法.Q1493_删掉一个元素以后全为1的最长子数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/03/2021 22:55
 **/

public class Solution {
    /**
     * 统计最多包含一个0的最长子数组长度,然后获得结果后减去1就是答案
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int left = 0;
        int count = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }
            while(count > 1){
                if(nums[left] == 0){
                    count--;
                }
                left++;
            }
            res = Math.max(i - left + 1, res);
        }
        return res - 1;
    }
}
