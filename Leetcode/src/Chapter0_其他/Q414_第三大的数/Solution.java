package Chapter0_其他.Q414_第三大的数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/12/2020 20:29
 **/

public class Solution {
    public int thirdMax(int[] nums) {
        //这里采用long，因为测试中有用到Integer.MIN_VALUE;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for(int num : nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
                //去掉重复的max1元素
            }else if(num == max1){
                continue;
            }else if(num > max2){
                max3 = max2;
                max2 = num;
                //去掉重复的max2元素
            }else if(num == max2){
                continue;
            }else if(num > max3){
                max3 = num;
            }
        }
        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }
}
