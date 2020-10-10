package Q32_从1到n整数中1出现的次数;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 27/04/2020 14:05
 **/

public class NumberOfOne {
    public int getNumbersOfOne(int n) {
        if (n < 0)
            throw new RuntimeException();
        else if (n == 0)
            return 0;
        char[] nums = String.valueOf(n).toCharArray();
        int start = 0;
        int end = nums.length;
        return NumberOf1(nums, start, end);
    }

    public int NumberOf1(char[] nums, int start, int end) {
        int first = nums[start] - '0';
        int length = end - start;
        if (first == 0 && length == 1)
            return 0;
        if (length == 1 && first > 0)
            return 1;

        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = powerBase10(length - 1);
        else if (first == 1) {
            StringBuffer buffer = new StringBuffer();
            int index = start + 1;
            while (index < nums.length) {
                buffer.append(nums[index]);
                index++;
            }
            numFirstDigit = Integer.parseInt(buffer.toString()) + 1;
        }
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);
        int numRecursive = NumberOf1(nums, start + 1, end);
        return numFirstDigit + numOtherDigits + numRecursive;


    }

    public int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    @Test
    void test(){
        Assertions.assertEquals(12,getNumbersOfOne(20));
        Assertions.assertEquals(1,getNumbersOfOne(5));
    }
}
