package Chapter4_双指针技巧.Q88_合并两个有序数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/12/2020 21:18
 **/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n -1;
        while(end >= 0){
            if(m > 0 && (n == 0  || nums1[m-1] >= nums2[n-1])){
                nums1[end] = nums1[m-1];
                m--;
            }else if(n > 0 &&(m == 0 || nums1[m-1] < nums2[n-1])){
                nums1[end] =  nums2[n-1];
                n--;
            }
            end--;
        }
    }
}
