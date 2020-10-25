package Chapter0_其他.Q398_随机数索引;

import java.util.Random;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/10/2020 21:39
 **/

public class Solution {
    Random r;
    int[] nums;
    public Solution(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int n = 0;
        int res = 0;
        for(int i =0; i < nums.length; i++){
            if(nums[i] == target){
                // 1/i *(1-1/(i+1)) *(1-1/(i+2))..... = 1/n
                if(r.nextInt(++n) == 0){
                    res = i;
                }
            }
        }
        return res;
    }
}
