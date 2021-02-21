package Chapter15_面试题.Q1610_生存人数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/02/2021 21:47
 **/

public class Solution {
    /**
     * 简单的差分数组应用,当前位置的数字等于前面所有位置的数字和
     * @param birth
     * @param death
     * @return
     */
    public int maxAliveYear(int[] birth, int[] death) {
        int[] nums = new int[2002];
        int sum = 0;
        for(int i = 0; i < birth.length; i++){
            nums[birth[i]] += 1;
            nums[death[i] + 1] -= 1;
        }
        int max = 0, index = -1;
        for(int i = 1900; i <= 2000; i++){
            sum += nums[i];
            if(max < sum){
                max = sum;
                index = i;
            }
        }
        return index;
    }
}
