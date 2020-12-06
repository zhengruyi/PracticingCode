package Chapter0_其他.Q135_分发糖果;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 15:57
 **/

public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int res = 0;
        //初始化为1，每个人至少分一块糖果
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        //先是从左往右遍历，每次如果当前分数比前一个大，那么至少给比前一个人多一个的糖果
        for(int i =1; i < len; i++){
            left[i] = ratings[i] > ratings[i-1] ? left[i-1] + 1 : left[i];
        }
        //从右往左，同样条件更新一遍
        for(int i = len - 2; i >= 0; i--){
            right[i] = ratings[i] > ratings[i+1] ? right[i+1] + 1 : right[i];
        }
        //去两个数组的最大值就是满足条件的解
        for(int i = 0; i < len; i++){
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
