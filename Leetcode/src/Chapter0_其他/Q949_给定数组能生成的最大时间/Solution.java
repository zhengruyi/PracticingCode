package Chapter0_其他.Q949_给定数组能生成的最大时间;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 00:38
 **/

public class Solution {
    /**
     * 由于最多只有四个数字，所以可以直接暴力搜索,判断有效性，取出最大值
     * @param arr
     * @return
     */
    public String largestTimeFromDigits(int[] arr) {
        int len = arr.length;
        int max = -1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(j == i){
                    continue;
                }
                for(int k = 0; k < len; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    int l = 6 - i - k - j;
                    int hours = arr[i] * 10 + arr[j];
                    int minute = arr[k] * 10 + arr[l];
                    if(hours < 24 && minute < 60){
                        max = Math.max(max,hours*60 + minute);
                    }
                }
            }
        }
        return max == -1 ? "" : String.format("%02d:%02d",max/60 , max % 60);
    }
}
