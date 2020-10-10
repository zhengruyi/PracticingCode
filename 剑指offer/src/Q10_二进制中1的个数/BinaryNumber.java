package Q10_二进制中1的个数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 22/04/2020 21:59
 **/

public class BinaryNumber {
    public int getOneNumbers(int number) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            int value = number & flag;
            if(value != 0)
                count++;

            flag = flag << 1;

        }
        return count;
    }
    //每个数和自己减1的结果相与获奖最右边的哪一位变成0
    public int getOneNumbers1(int number) {
        int count = 0;
        while (number != 0){
            count++;
            number = number & (number-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 0b11111111_11111111_11111111_11111011;
        System.out.println(a);
    }

    @Test
    void test(){
        Assertions.assertEquals(1,getOneNumbers(1));
        Assertions.assertEquals(1,getOneNumbers1(1));

        Assertions.assertEquals(2,getOneNumbers(0b10000001));
        Assertions.assertEquals(2,getOneNumbers1(0b10000001));

        Assertions.assertEquals(31,getOneNumbers(-5));
        Assertions.assertEquals(31,getOneNumbers1(-5));
    }
}
