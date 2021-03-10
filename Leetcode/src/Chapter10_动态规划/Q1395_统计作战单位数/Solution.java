package Chapter10_动态规划.Q1395_统计作战单位数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/03/2021 22:47
 **/

public class Solution {
    public int numTeams(int[] rating) {
        int len = rating.length;
        //四个dp数组分别表示左边有多少个数小于当前数字，也有几个数字大于当前数字
        //和右边有几个数字小于以及大于当前数字
        int[] smallLeft = new int[len];
        int[] bigLeft = new int[len];
        int[] smallRight = new int[len];
        int[] bigRight = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i; j++){
                if(rating[j] < rating[i]){
                    smallLeft[i]++;
                }
                if(rating[j] > rating[i]){
                    bigLeft[i]++;
                }
            }

            for(int j = len - 1; j > i; j--){
                if(rating[j] < rating[i]){
                    smallRight[i]++;
                }
                if(rating[j] > rating[i]){
                    bigRight[i] ++;
                }
            }
        }
        int ans = 0;
        //总数是两两乘积的和
        for(int i = 1; i < len - 1; i++){
            ans += smallLeft[i] * bigRight[i];
            ans += bigLeft[i] * smallRight[i];
        }
        return ans;
    }
}
