package Q11_数值的整数次方;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 23/04/2020 12:48
 **/

public class Power {
    public double power(double base, int exponent) {
        if (equal(base, 0.0d) && exponent == 0)
            return 0;
        else if (exponent < 0) {
            double result = powerPositive(base, -1 * exponent);
            return 1.0 / result;
        } else {
            return powerPositive(base, exponent);
        }
    }

    public double powerPositive(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = powerPositive(base, exponent >> 1);
        result *= result;
        int flag = exponent & 0x1;
        if (flag == 1)
            result *= base;
        return result;
    }

    public boolean equal(double a, double b) {
        if (Math.abs(a - b) < 0.000000001)
            return true;
        else
            return false;
    }

    @Test
    void test() {
        Assertions.assertEquals(4, power(2, 2));
        Assertions.assertEquals(0.25, power(2, -2));
        Assertions.assertEquals(1, power(8, 0));
        Assertions.assertEquals(4, power(-2, 2));
        Assertions.assertEquals(-0.125, power(-2, -3));
        Assertions.assertEquals(1, power(-2, 0));
    }
}
