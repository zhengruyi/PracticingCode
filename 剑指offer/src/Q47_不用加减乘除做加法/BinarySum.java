package Q47_不用加减乘除做加法;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 30/04/2020 11:36
 **/

public class BinarySum {
    public int getSum(int n, int m){
        int raw = n ^ m; //计算不进位的结果
        int takeOver = (n & m) << 1; //计算进位的结果
        while (takeOver != 0){ // 把n+m的和转化成 不进位结果和进位结果的和，一直迭代下去直到进位为0
            n = raw ^ takeOver;
            m = (raw & takeOver) << 1;
            raw = n;
            takeOver = m;
        }
        return raw;
    }

    @Test
    void test(){
        Assertions.assertEquals(22,getSum(5,17));
    }
}
