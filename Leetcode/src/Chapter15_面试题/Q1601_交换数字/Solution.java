package Chapter15_面试题.Q1601_交换数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 13/01/2021 19:47
 **/

public class Solution {
    /**
     * 异或法进行数字交换是最优的因为可以避免数字溢出的问题
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
