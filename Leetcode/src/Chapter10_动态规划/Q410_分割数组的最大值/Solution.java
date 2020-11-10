package Chapter10_动态规划.Q410_分割数组的最大值;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 10/11/2020 22:04
 **/

public class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        //left存储数组的元素的最大值，right表示数字的最大元素和
        for(int i : nums){
            right += i;
            if(left < i){
                left = i;
            }
        }
        //进行二分搜索，找到子数组和的最大值的最小值，终止条件时left == right
        // 当left要找的值比数组中的最大值还大时,left 会到达右极限
        while(left < right){
            int mid = left + (right - left )/2;
            if(check(nums,m,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[] nums, int m, int mid){
        int cnt = 1;
        int sum = 0;
        //当子数组和大于mid时，重新创建一个子数组
        for(int i : nums){
            if(sum + i > mid){
                sum = i;
                cnt++;
            }else{
                sum += i;
            }
        }
        //判断当前子数组数目是否小于等于m
        return cnt <= m;
    }
}
