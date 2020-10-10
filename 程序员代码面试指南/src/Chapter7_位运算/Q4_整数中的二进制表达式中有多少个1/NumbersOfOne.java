package Chapter7_位运算.Q4_整数中的二进制表达式中有多少个1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 15/06/2020 10:40
 **/

public class NumbersOfOne {
    public int getNumber1(int n){
        int res = 0;
        while (n != 0){
            if((n & 1) == 1){
                res++;
            }
            n >>>= 1;
        }
        return res;
    }
    public int getNumber2(int n){
        int res = 0;
        while (n != 0){
            res++;
            n = n & (n-1);
        }
        return res;
    }

    public int getNumber3(int n){
        int res = 0;
        while (n != 0){
            res++;
            n -= n & (~n +1);
        }
        return res;
    }

    @Test
    void test1(){
        Assertions.assertEquals(2,getNumber1(3));
        Assertions.assertEquals(32,getNumber1(-1));
    }

    @Test
    void test2(){
        Assertions.assertEquals(2,getNumber2(3));
        Assertions.assertEquals(32,getNumber2(-1));
    }

    @Test
    void test3(){
        Assertions.assertEquals(2,getNumber3(3));
        Assertions.assertEquals(32,getNumber3(-1));
    }
}
