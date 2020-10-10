package Chapter7_位运算.Q5_在其他数都出现偶数次的数组中找到出现奇数次的数字;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 11:09
 **/

public class FindNumber {
    /**
     * 只有一个数字出现奇数次
     *
     * @param arr
     * @return
     */
    public int find(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException();
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public int[] findTwo(int[] arr) {
        int a = 0;
        int tmp = 0;
        int lastOne = 0;
        int[] res = new int[2];
        //求出所有数字的异或
        for (int i = 0; i < arr.length; i++) {
            tmp ^= arr[i];
        }
        //在该异或和中找到最右边数字为1这一列
        for (int i = 1; i < Integer.MAX_VALUE; i = i * 2) {
            if ((tmp & i) != 0) {
                lastOne = i;
                break;
            }
        }
        //在遍历一次数组，在数组中把所有lastOne位置为1的数字的求出异或和，则该结果就是其中一个出现为奇数次的数字
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & lastOne) > 0){
                a ^= arr[i];
            }
        }
        res[0] = a;
        //有两个数字的异或，并且知道其中一个数字，那么很容易就可以求出另外一个数字
        res[1] = a ^ tmp;
        return res;
    }


    @Test
    void test() {
        Assertions.assertEquals(5, find(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}));
        Assertions.assertEquals(-1, find(new int[]{1, 2, 3, 4, -1, 4, 3, 2, 1}));
    }

    @Test
    void test1() {
        int[] res = findTwo(new int[]{1, 2, 3, 4, 5, 6,4, 3, 2, 1});
        Assertions.assertEquals(5, res[0]);
        Assertions.assertEquals(6, res[1]);
        res = findTwo(new int[]{1, 2, 3, 4, -1,-3, 4, 3, 2, 1});
        Assertions.assertEquals(-1, res[0]);
        Assertions.assertEquals(-3, res[1]);
    }
}
