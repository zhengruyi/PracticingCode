package Chapter8_贪心算法.Q55_跳跃游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/10/2020 22:54
 **/

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null){
            return false;
        }
        int farthest = 0;
        //farthest表示最远可以跳到的距离，这里只选择遍历到 nums.length - 1是为了
        //防止出现刚好跳到最后位置时触发条件返回false,事实上，如果能跳到nums.length-2,则一定可以
        //跳到最后，因为每个元素都大于等于1
        for(int i = 0; i< nums.length - 1; i++){
            //基于当前元素来更新最远可以跳到的距离
            farthest = Math.max(farthest,i+nums[i]);
            //当farthest == i时，意味着过去所有的路劲都没办法跳到i+1,所以返回false;
            if(farthest == i){
                return false;
            }
        }
        return true;
    }
}
