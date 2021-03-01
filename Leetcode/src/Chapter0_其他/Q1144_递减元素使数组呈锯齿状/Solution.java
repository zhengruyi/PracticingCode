package Chapter0_其他.Q1144_递减元素使数组呈锯齿状;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 01/03/2021 22:20
 **/

public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int odd = 0;
        int even = 0;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            //当前处于偶数位置,
            if(i % 2 == 0){
                int e1 = 0;
                int e2 = 0;
                //计算要求两边奇数位置的元素都小于自己需要做的修改
                if(i > 0 && nums[i] >= nums[i-1]){
                    e1 = nums[i] - nums[i - 1] + 1;
                }
                if(i < len - 1 && nums[i] >= nums[i+1]){
                    e2 = nums[i] - nums[i + 1] + 1;
                }
                even += Math.max(e1,e2);
            }else{
                //当前i处于奇数位置
                int d1 = 0;
                int d2 = 0;
                //计算把前后偶数位置的元素都小于自己需要减去的数字
                if(nums[i] >= nums[i-1]){
                    d1 = nums[i] - nums[i - 1] + 1;
                }

                if(i < len - 1 && nums[i] >= nums[i+1]){
                    d2 = nums[i] - nums[i+ 1] + 1;
                }
                odd += Math.max(d1,d2);
            }
        }
        //来那个种情况取最小值就可以
        return Math.min(even,odd);
    }
}
