package Chapter0_其他.Q1356_根据数字二进制下1的数目排序;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/03/2021 23:09
 **/

public class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            //因为数字最大到10000,所以充分利用高位是0的特征,进行数据存储
            arr[i] = Integer.bitCount(arr[i]) * 10_0000 + arr[i];
        }
        //排序后退回成原始数据就可以
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            //高于10_0000的数字都是数字中的1的数目
            arr[i] %= 10_0000;
        }
        return arr;
    }
}
