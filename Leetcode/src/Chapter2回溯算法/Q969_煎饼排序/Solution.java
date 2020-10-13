package Chapter2回溯算法.Q969_煎饼排序;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/10/2020 22:52
 **/

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        if(arr == null || arr.length == 0){
            return res;
        }
        backTrack(arr, arr.length, res);
        return res;
    }

    /**
     * 回溯算法，采用递归实现，每次把前面n个元素的最大值放到第n位，然后n-1递归下去
     * @param arr
     * @param n
     * @param res
     */
    public void backTrack(int[] arr, int n,List<Integer> res){
        if(n == 1){
            return ;
        }
        int max = 0;
        //找到最大值的下表
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        if(max != n-1){
            res.add(max+1);
            //反转1-max个元素,反转后最大元素在数组的第一位
            for(int i =0; i <= max /2; i++){
                int tmp = arr[i];
                arr[i] = arr[max -i];
                arr[max -i] = tmp;
            }
            //反转前n位把第一位的最大值翻转到第n位
            res.add(n);
            for(int i =0; i <= (n - 1)/2; i++){
                int tmp = arr[i];
                arr[i] = arr[n- 1 -i];
                arr[n -1 -i] = tmp;
            }
        }
        //递归排序前n-1个元素
        backTrack(arr,n-1,res);
    }
    @Test
    void test(){
        int[] nums = {3,2,4,1};
        pancakeSort(nums);
    }
}
