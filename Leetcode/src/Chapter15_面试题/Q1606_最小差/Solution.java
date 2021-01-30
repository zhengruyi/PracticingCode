package Chapter15_面试题.Q1606_最小差;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/01/2021 21:30
 **/

public class Solution {
    /**
     * 先对两个数组分别进行排序，然后用两个指针分别从低到高进行右移
     * 计算绝对值的最小差,注意数字溢出的处理
     * @param a
     * @param b
     * @return
     */
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long res = Integer.MAX_VALUE;
        while(i < a.length && j < b.length){
            res = Math.min(res,Math.abs((long)a[i] - (long)b[j]));
            if(a[i] < b[j]){
                ++i;
            }else{
                ++j;
            }
        }
        return (int) res;
    }
}
