package Chapter0_其他.Q18_早餐组合;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/02/2021 22:48
 **/

public class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        //对两个数组进行排序
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0;
        int j = drinks.length - 1;
        //双指针,来计算符合要求的组合个数，因为j一定是递减的
        //所以j不用每次都移到末尾，逐次递减就行
        for(int i = 0; i < staple.length; i++){
            int price = x - staple[i];
            for(; j>= 0; j--){
                if(drinks[j] <= price){
                    break;
                }
            }
            res = (res + (j+1))% 1_000_000_007;
        }
        return res;
    }
}
