package Q66_构建乘积数组;

import java.util.Arrays;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 05/02/2021 23:33
 **/

public class Solution {
    /**
     * 构建前缀积和后缀积的数组，然后每次遍历就可以直接用两个数组快速计算出给元素两边的数组乘积和
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        if(a.length == 0){
            return res;
        }
        int[] first = new int[len+1];
        int[] last = new int[len+1];
        Arrays.fill(first,1);
        Arrays.fill(last,1);
        for(int i = 0; i < len; i++){
            first[i+1] = first[i] * a[i];
            last[len - 1 - i] = last[len - i] * a[len - 1 - i];
        }

        for(int i = 0; i < len; i++){
            res[i] = first[i] * last[i+1];
        }
        return res;
    }
}
