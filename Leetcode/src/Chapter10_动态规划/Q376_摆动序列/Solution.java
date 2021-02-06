package Chapter10_动态规划.Q376_摆动序列;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/02/2021 22:48
 **/

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        //表示以i为结尾的上升摆动序列的长度
        int[] up = new int[len];
        //表示以j为结尾的下降摆动序列的长度
        int[] down = new int[len];
        //初始第一个数字，上升和下降序列的长度都是1
        up[0] = 1;
        down[0] = 1;
        for(int i = 1; i < len; i++){
            //当前数字大于上一个数字时,那么上升摆动序列长度不变
            //或者等于下降摆动序列加1
            if(nums[i] > nums[i-1]){
                up[i] = Math.max(up[i-1], down[i - 1] + 1);
                down[i] = down[i-1];

                //当前数字小于上一个数字时,那么下降摆动序列长度不变
                //或者等于上升摆动序列加1
            }else if(nums[i] < nums[i-1]){
                down[i] = Math.max(down[i-1],up[i-1] + 1);
                up[i] = up[i-1];
            }else{
                //前后数字相等,那么就保持不变
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[len-1],down[len-1]);
    }
}
