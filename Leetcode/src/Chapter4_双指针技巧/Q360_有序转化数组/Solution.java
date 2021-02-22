package Chapter4_双指针技巧.Q360_有序转化数组;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/02/2021 23:19
 **/

public class Solution {
    /**
     * 根据a 和 b的符号来判断中间点是最大值还是最小值,如果中间点是最大值,那么两个指针指向两端
     * 每次取两个值中的最小值,从0开始往数组末尾排列,如果中间是最小值，那么久取两个指针中的在较大值
     * 然后从数组末尾往开头填
     * @param nums
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        boolean increasing = true;
        if(a > 0){
            index = res.length - 1;
            increasing = false;
        }else if (a < 0){
            index = 0;
        }else{
            if(b >= 0){
                index = 0;
            }else{
                index = res.length - 1;
                increasing = false;
            }
        }
        while(left <= right){
            int n1 = getResult(a,b,c,nums[left]);
            int n2 = getResult(a,b,c,nums[right]);
            if(increasing){
                if(n1 < n2){
                    res[index++] = n1;
                    left++;
                }else{
                    res[index++] = n2;
                    right--;
                }
            }else{
                if(n1 > n2){
                    res[index--] = n1;
                    left++;
                }else{
                    res[index--] = n2;
                    right--;
                }
            }
        }
        return res;
    }
    public int getResult(int a, int b, int c, int num){
        return  a * num * num + b * num + c;
    }
}
