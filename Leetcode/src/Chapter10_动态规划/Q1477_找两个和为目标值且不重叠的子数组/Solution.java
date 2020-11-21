package Chapter10_动态规划.Q1477_找两个和为目标值且不重叠的子数组;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 21/11/2020 16:54
 **/

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if(arr.length == 0){
            return -1;
        }
        ArrayList<int[]> array = new ArrayList <int[]>();
        int left = 0;
        int right = 0;
        int sum = 0;
        //滑动窗口求出所有子数组和等于target的子树组，并且将[数组长度,起始索引]存入数组中
        while(right < arr.length){
            sum += arr[right++];
            if(sum < target){
                continue;
            }
            while(sum > target){
                sum -= arr[left++];
            }
            if(sum == target){
                array.add(new int[]{right - left, left});
            }
        }
        //按照数组长须排序,从小到大排序
        Collections.sort(array, (o1, o2)-> o1[0] - o2[0]);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < array.size();i++){
            int[] array1 = array.get(i);
            //满足条件时，后续数组的长度肯定大于当前值，直接跳出
            if(array1[0] * 2 >= ans){
                break;
            }
            for(int j = i + 1; j < array.size();j++){
                int[] array2 = array.get(j);
                //判断两个子数组是否存在重复,重复则取下一个区间
                if(array1[1] < array2[1] && array1[0] + array1[1] > array2[1]){
                    continue;
                }
                if(array2[1] < array1[1] && array2[0] + array2[1] > array1[1]){
                    continue;
                }
                ans = Math.min(array1[0]+array2[0], ans);
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
