package Chapter8_贪心算法.Q45_跳跃游戏II;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/10/2020 23:02
 **/

public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int end = 0;
        int farthest = 0;
        int jump = 0;
        //为防止出现 end == nums.length -1 时出现的多跳一次，所以只遍历到nums.length -2
        for(int i = 0; i< nums.length - 1; i++){
            farthest = Math.max(farthest,i+nums[i]);
            //到达上一次跳跃点所能达到的最远距离，必须要在跳一次了
            if(i == end){
                jump++;
                //更新最远能跳到距离
                end = farthest;
            }
        }
        return jump;
    }
}
