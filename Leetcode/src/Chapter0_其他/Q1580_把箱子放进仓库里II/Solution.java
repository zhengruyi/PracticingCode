package Chapter0_其他.Q1580_把箱子放进仓库里II;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/03/2021 23:20
 **/

public class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = warehouse[0];
        right[n-1] = warehouse[n-1];
        //left,right分别表示从左边和右边进入
        //能够获得的空间,在各自的空间上呈现递减的趋势
        for(int i = 1; i < n; i++){

            if(warehouse[i] <= left[i-1]){
                left[i] = warehouse[i];
            }else{
                left[i] = left[i-1];
            }
            if(warehouse[n-i - 1] <= right[n-i]){
                right[n-i-1] = warehouse[n-i-1];
            }else{
                right[n-i-1] = right[n-i];
            }
        }
        int[] rooms = new int[n];
        //选择两个方向上的最大值,之所以可以是因为单调性,因为如果在i位置上left[i] < right[i]
        //那么所有的i+1..n都会选择right方向上的,表示从右边推入
        for(int i = 0; i < n; i++){
            rooms[i] = Math.max(left[i],right[i]);
        }
        Arrays.sort(boxes);
        Arrays.sort(rooms);
        int res = 0;
        //将箱子按容量从小到大遍历
        for(int i = 0, j = 0; i < boxes.length; i++){
            //选择可以装入的空间
            while(j < n && rooms[j] < boxes[i]){
                j++;
            }
            if(j == n){
                return res;
            }
            j++;
            res++;
        }
        return res;
    }
}
