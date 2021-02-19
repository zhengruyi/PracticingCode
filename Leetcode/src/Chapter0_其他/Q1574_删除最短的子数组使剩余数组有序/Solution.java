package Chapter0_其他.Q1574_删除最短的子数组使剩余数组有序;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 19/02/2021 22:57
 **/

public class Solution {
    /**
     * 要求移除最短的子数组后,整个数组是升序的,阶梯思路是分别求出做左右的有序数组，优先考虑删除另外一半，只保留左右有序部分
     * 所需要删除的数组长度.然后逐个比较左右两块有序部分，尝试删除中间的数组，比较哪种方案要删除的数组长度最短
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        //从左往右找最长的有序序列
        while(left < n - 1 && arr[left] <= arr[left + 1]){
            left++;
        }
        //如果数组是完全有序的，那么就直接返回0，表示数组不需要移除任何一个元素, 0..left
        if(left == n - 1){
            return 0;
        }
        int right = n-1;
        //从右往左进行寻找有序序列,right .. end
        while(right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        //表示删除右边部分( n-1 - left - 1 + 1, 和左边部分 0..right - 1
        int res = Math.min(n - left - 1, right);
        int i = 0;
        int j = right;
        //尝试删除中间部分,
        while(i <= left && j < n){
            if(arr[i] <= arr[j]){
                //要删除区间 i+1 .. j-1
                res = Math.min(res, j - i - 1);
                i++;
            }else{
                //区间长度肯定更长
                j++;
            }
        }
        return res;
    }
}
