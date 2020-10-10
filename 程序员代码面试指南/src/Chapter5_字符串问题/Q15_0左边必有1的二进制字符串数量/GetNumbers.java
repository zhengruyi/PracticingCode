package Chapter5_字符串问题.Q15_0左边必有1的二进制字符串数量;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 12/06/2020 16:02
 **/

public class GetNumbers {
    public int getNumberOne(int n) {
        if (n < 1) {
            return 0;
        }
        return process(n, 1);
    }

    public int process(int n, int i) {
        if (i == n) {
            return 1;
        }
        if (i == n - 1) {
            return 2;
        }
        return process(n, i + 1) + process(n, i + 2);
    }

    public int getNumberTwo(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 1;
        int cur = 1;
        int tmp = 0;
        for (int i = 2; i < n + 1; i++) {
            tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return  cur;
    }

    @Test
    void test() {
        Assertions.assertEquals(1, getNumberOne(1));
        Assertions.assertEquals(2, getNumberOne(2));
        Assertions.assertEquals(3, getNumberOne(3));
    }

    @Test
    void test1() {
        Assertions.assertEquals(1, getNumberTwo(1));
        Assertions.assertEquals(2, getNumberTwo(2));
        Assertions.assertEquals(3, getNumberTwo(3));
    }
}
