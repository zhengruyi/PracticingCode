package Chapter0_其他.Q553_最优除法;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/01/2021 21:18
 **/

public class Solution {
    /**
     * 所有数字的大小都是2~1000
     * 由于不能改变被除数，所以除数最小，整体结果最大
     * 而除数的计算中，当b/c/d..这种格式除数最小
     *
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        if(nums.length == 1){
            return String.valueOf(nums[0]);
        }else if(nums.length == 2){
            return nums[0] +"/"+nums[1];
        }
        //拼装字符串组成最终答案,根据解释最终的格式一定是a/(b/c/d/e)
        StringBuilder builder = new StringBuilder(nums[0] + "/(" + nums[1]);
        for(int i = 2; i < nums.length; i++){
            builder.append("/"+nums[i]);
        }
        builder.append(")");
        return builder.toString();
    }
}
