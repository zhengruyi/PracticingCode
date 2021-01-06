package Chapter3二分查找.Q1300_转变数组后最接近目标值的数组和;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/01/2021 20:06
 **/

public class Solution {
    /**
     * 整体思路就是用二分搜索在0和最大值之间二分搜索
     * 一个value,这个值是使得数组中的所有大于value转换成value
     * 后整体和下于等于target的最大value.
     * 由此可知存在value+1,使得转换后数组值大于等于target的最小值
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int left = 0;
        int right = arr[n-1];
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            //这里注意binarySear函数作用，如果数字存在数组中
            //那么结果就是在数组中的索引是正数，如果不存在会返回
            //小于目标值的所有元素中最大值所在的长度 = -index-1
            int index = Arrays.binarySearch(arr,mid);

            if(index < 0){
                index = -index -1;
            }
            int curr = prefix[index] + (n - index) * mid;

            if(curr <= target){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid -1;
            }
        }
        //检验两个目标值, 哪个更符合要求就返回哪个
        int small = check(arr,ans);
        int big = check(arr, ans+1);
        return Math.abs(target - small) <= Math.abs(target - big) ? ans : ans + 1;

    }
    public int check(int[] arr, int threshold){
        int sum = 0;
        for(int num : arr){
            sum += Math.min(num,threshold);
        }
        return sum;
    }
}
