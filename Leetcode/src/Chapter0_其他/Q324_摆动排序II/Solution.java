package Chapter0_其他.Q324_摆动排序II;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/01/2021 19:53
 **/

public class Solution {
    /**
     * nums[0] < nums[1] > nums[2] < nums[3]...
     * 满足这种排序的数组称为摆动数组
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        //复制一份数组
        int[] copy = nums.clone();
        //对数组进行排序
        Arrays.sort(copy);
        int len = nums.length;
        //然后按奇偶性反着交错排列就可以
        //不能正向交错排列,因为1223这种结构正向交错排列
        // 还是不能满足条件
        for(int i = 1; i < nums.length; i+=2){
            nums[i] = copy[--len];
        }
        for(int i = 0; i < nums.length; i+=2){
            nums[i] = copy[--len];
        }
    }
}
