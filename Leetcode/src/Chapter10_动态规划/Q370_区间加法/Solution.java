package Chapter10_动态规划.Q370_区间加法;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/11/2020 11:07
 **/

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        //给区间i..j中间的每个数字都加上一个数字等于给差分数组的索引i处加上数字，然后在j+1处在减去这个数子
        for(int i = 0; i < updates.length; i++){
            nums[updates[i][0]] += updates[i][2];
            if(updates[i][1] + 1 < length){
                nums[updates[i][1]+1] -= updates[i][2];
            }
        }
        //要得到的元素组，则要求前缀和，因为差分数组就是求相邻两个数字的差值得来的
        //而前缀和则是相反的过程
        for(int i =1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
