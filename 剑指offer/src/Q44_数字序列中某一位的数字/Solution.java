package Q44_数字序列中某一位的数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 09/01/2021 23:56
 **/

public class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        //因为在计算工过程中可能会有溢出的情况，所以要用long
        long count = 9;
        long start = 1;
        //先确定大概范围,0-9中间有9个数字，10-99有90个数字 100-999 有900个数字
        //按照这个规律可以确定大概范围
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * 9 * start;
        }
        //由于从0开始计算，而start表示0随意要用n-1
        long num = start + (n - 1)/digit;
        //最后n把数字转换成字符串在返回特定位置的字符
        return String.valueOf(num).charAt((n-1) % digit) - '0';
    }
}
