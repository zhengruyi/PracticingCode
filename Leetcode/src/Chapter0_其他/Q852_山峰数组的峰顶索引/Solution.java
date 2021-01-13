package Chapter0_其他.Q852_山峰数组的峰顶索引;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 20:03
 **/

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 1; i < arr.length -1; i++){
            //峰顶索引的特性
            if(arr[i] > arr[i+1] && arr[i] > arr[i-1]){
                return i;
            }
        }
        return -1;
    }
}
