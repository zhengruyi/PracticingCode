package Chapter1差分数组和前缀和数组.Q1094_拼车;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/03/2021 22:49
 **/

public class Solution {
    /**
     * 简单的差分数组应用
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums =  new int[1001];
        for(int[] trip : trips){
            nums[trip[1]] += trip[0];
            //由于到目的地,遵循先下车再上车的原则,所以这里是trip[2]而不是trip[2]+1
            nums[trip[2]] -= trip[0];
        }
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
            if(nums[i] > capacity){
                return false;
            }
        }
        return true;
    }
}
