package Chapter4_递归和动态规划.Q6_汉诺塔问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 06/06/2020 16:16
 **/

public class Hanoi {
    public static void hanoi(int num) {
        if (num < 1) {
            return;
        }
        transfer("left", "mid", "right", num);
    }

    public static void transfer(String from, String mid, String to, int num) {
        if (num == 1) {
            System.out.println(" move from " + from + " to " + to);
        } else {
            //那上面i-1个移到中间
            transfer(from, to, mid, num - 1);
            //把最后一个移到中间
            transfer(from, mid, to, 1);
            //把中间的i-1个移到右边就完成操作了
            transfer(mid, from, to, num - 1);
        }
    }

    public int getStep(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return process(arr,arr.length-1,1,2,3);
    }

    public int process(int[] arr, int i, int from, int mid, int to) {
        if (i == -1) {
            return 0;
        }
        if (arr[i] != from && arr[i] != to) {
            return -1;
        }
        //根据移动步奏来反向判
        if (arr[i] == from) {
            //最大的那个任然在原来的位置上
            return process(arr, i - 1, from, mid, to);
        } else {
            //做大的那个已经在to上，所以已经至少过了2^(i-1)
            int rest = process(arr, i - 1, mid, from, to);
            if (rest == -1) {
                return -1;
            }
            return (1 << i) + rest;
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
    @Test
    void test(){
        Assertions.assertEquals(3,getStep(new int[]{3,3}));
    }
}
