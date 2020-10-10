package Chapter7_位运算.Q6_在其他数都出现k次的数组中找到只出现一次的数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 14:54
 **/

public class FindNumber {
    /**
     * 原理 ： k个k进制数字无进位相加的和为0
     * @param arr
     * @param k
     * @return
     */
    public int findNumber(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1) {
            throw new RuntimeException();
        }
        int[] res = new int[32];
        for (int i = 0; i < arr.length; i++) {
            setExclusive(res,arr[i],k);
        }
        return getNumberFromKbit(res,k);
    }

    public int[] transform(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    public int getNumberFromKbit(int[] arr, int k) {
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res = res * k + arr[i];
        }
        return res;
    }

    public void setExclusive(int[] arr, int value, int k) {
        int[] valueK = transform(value, k);
        for (int i = 0; i < valueK.length; i++) {
            arr[i] = (arr[i] + valueK[i]) % k;
        }
    }

    @Test
    void test(){
        Assertions.assertEquals(4,findNumber(new int[]{1,1,2,3,4,2,3,1,2,3},3));
    }
}
