package Chapter0_其他.Q681_最近时刻;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 31/01/2021 23:08
 **/

public class Solution {
    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        int index = 0;
        //将字符串数组转化成数字
        for(int i = 0; i < time.length(); i++){
            if(i == 2){
                continue;
            }
            nums[index++] = time.charAt(i) - '0';
        }
        //获得数组中的最小值
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min,nums[i]);
        }
        //标记是否能在当天内找到下一个更大的时间
        boolean found = false;
        //从后往前将较小的值转变成较大的值
        for(int i = nums.length - 1; i >= 0; i--){
            int max = Integer.MAX_VALUE;
            //找到比当前i指向的数字大的最小数字
            for(int j = 0; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    max = Math.min(max,nums[j]);
                }
            }
            if(max != Integer.MAX_VALUE){
                //将i位置的数字换成较大的数字
                int temp = nums[i];
                nums[i] = max;
                //检查是否有效
                if(isValid(nums)){
                    //将后续数字换成较小的数字
                    for(int k = i + 1; k < nums.length; k++){
                        nums[k] = min;
                    }
                    //标记数字已经找到
                    found = true;
                    break;
                }else{
                    //当前数字无效,恢复初始值
                    nums[i] = temp;
                }
            }
        }
        //说明当天没有较大的值
        if(!found){
            //第二天的最小值
            for(int i = 0; i < nums.length; i++){
                nums[i] = min;
            }
        }
        //构建答案
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            if(i == 2){
                builder.append(":");
            }
            builder.append(nums[i]);
        }
        return builder.toString();
    }
    public boolean isValid(int[] nums){
        if(nums[0] > 2 || nums[0] == 2 && nums[1] > 3 || nums[2] > 5){
            return false;
        }
        return true;
    }
}
