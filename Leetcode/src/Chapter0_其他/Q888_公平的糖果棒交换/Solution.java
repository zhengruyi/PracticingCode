package Chapter0_其他.Q888_公平的糖果棒交换;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/03/2021 23:00
 **/

public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        if(sumA > sumB){
            int[] res =  fairCandySwap(B,A);
            int temp = res[1];
            res[1] = res[0];
            res[0] = temp;
            return res;
        }
        //排序是为了用双指针来加速筛选出特定组合
        Arrays.sort(A);
        Arrays.sort(B);
        //计算两个数组的和的差值
        int gap = sumB - sumA;
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            //双指针搜索数组
            int tmp = 2 * (B[j] - A[i]);
            if(tmp == gap){
                return new int[]{A[i],B[j]};
            }else if(tmp < gap){
                j++;
            }else{
                i++;
            }
        }
        return new int[]{};
    }
}
