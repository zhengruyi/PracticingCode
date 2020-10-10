package Chapter7_位运算.Q3_只有位运算不用算数运算实现整数的加减乘除运算;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 14/06/2020 20:45
 **/

public class CalculateWithBit {
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int tmpSum = sum ^ carry;
            int tmpCarry = (sum & carry) << 1;
            sum = tmpSum;
            carry = tmpCarry;
        }
        return sum;
    }

    public int minus(int a, int b) {
        //负数的表示方式是采用补码，即原数的反码(~是全部取反)在加上1
        int minusB = add(~b, 1);
        return add(a, minusB);
    }

    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = add(res, a);
            }
            a <<= 1;
            // >>>表示无符号进位，不然在b等于负数情况下，b的最左边会不停填入1，永远不可能为0
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public boolean isNeg(int n) {
        return n < 0;
    }

    public int negNum(int n) {
        return add(~n, 1);
    }

    public int divide(int a, int b) {
        if (a != Integer.MIN_VALUE && b != Integer.MIN_VALUE) {
            return div(a, b);
        } else if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (a != Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 0;
        } else {
            int c = div(add(a, 1), b);
            int rest = div(minus(a, multi(c, b)), b);
            return c + rest;
        }
    }

    @Test
    void testAdd() {
        Assertions.assertEquals(10, add(2, 8));
        Assertions.assertEquals(18, add(10, 8));
    }

    @Test
    void testDifference() {
        Assertions.assertEquals(2, minus(10, 8));
        Assertions.assertEquals(19, minus(100, 81));
    }

    @Test
    void testMulti() {
        Assertions.assertEquals(10, multi(5, 2));
        Assertions.assertEquals(40, multi(10, 4));
        Assertions.assertEquals(-40, multi(10, -4));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(5, divide(10, 2));
        Assertions.assertEquals(10, divide(40, 4));
        Assertions.assertEquals(10, divide(-40, -4));
        Assertions.assertEquals(-10, divide(-40, 4));
        Assertions.assertEquals(0, divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
        Assertions.assertEquals(-1, divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
