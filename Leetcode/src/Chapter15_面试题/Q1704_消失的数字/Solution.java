package Chapter15_面试题.Q1704_消失的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 28/03/2021 23:10
 **/

public class Solution {
    /**
     * 本质逻辑就是用数组下标组成哈希表,把数组数字放到他应该的位置
     * 然后剩下的就是在遍历一遍数组,从左往右找到第一个不符个要求nums[i] != i
     * 的数字,那么这个数字就是第一个缺失的整数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < nums.length; i++){
            //循环来找到满足条件的位置
            while(nums[i] != i && nums[i] < n){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return n;
    }
}
