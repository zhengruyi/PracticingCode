package Chapter15_面试题.Q1621_交换和;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/03/2021 22:34
 **/

public class Solution {
    /**
     * 注意一下两者差为奇数，需要考虑到小数点的情况
     * @param array1
     * @param array2
     * @return
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        if(sum1 > sum2){
            int[] tmp = findSwapValues(array2,array1);
            if(tmp.length > 0){
                int temp = tmp[0];
                tmp[0] = tmp[1];
                tmp[1] = temp;
            }
            return tmp;
        }
        double gap = (sum2 - sum1)/2.0;
        Set <Double> set = new HashSet();
        for(int num : array1){
            set.add(num*1.0);
        }
        for(int num : array2){
            if(set.contains(num - gap)){
                return new int[]{(int)(num - gap), num};
            }
        }
        return new int[]{};
    }
}
