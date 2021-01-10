package Chapter0_其他.Q845_数组中的最长山脉;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/01/2021 21:11
 **/

public class Solution {
    public int longestMountain(int[] arr) {
        int max = 0;
        int i = 1;
        while(i < arr.length){
            int increasing = 0;
            int decreasing = 0;
            //因为山脉的要求时先上升再下降,这里计算上升序列长度
            while(i < arr.length && arr[i-1] < arr[i]){
                i++;
                increasing++;
            }
            //再计算下降序列长度
            while(i < arr.length && arr[i-1] > arr[i]){
                i++;
                decreasing++;
            }
            //上升和下降序列同时存在，那么更新最长的山脉宽度
            if(increasing > 0 && decreasing > 0){
                max = Math.max(max, increasing + decreasing + 1);
            }
            while( i < arr.length && arr[i-1] == arr[i]){
                i++;
            }
        }
        return max;
    }
}
