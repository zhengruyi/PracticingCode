package Chapter0_其他.Q400_第N位数字;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 18/01/2021 21:06
 **/

public class Solution {
    public int findNthDigit(int n) {
        if(n < 9){
            return n;
        }
        long mul = 1;
        int digit = 1;
        long sum = 0;
        //首先建立一个大概的范围，确定n大概是在几位数中
        //每次mul乘上10，digit便是数字的位数，每次递增
        while(sum < n){
            sum += 9 * mul * digit;
            digit++;
            mul *= 10;
        }
        mul /= 10;
        digit--;
        long start = mul;
        //计算在具体范围内距离start的偏移量(数位单位)
        n = n - (int)(sum - 9 * mul * digit);
        //计算出具体的数字,这里是n-1，因为从start开始，所以相当于0开始
        int offset = (n-1)/digit;
        n -= offset * digit;
        //返回数字的具体的哪一位
        return String.valueOf(start+offset).charAt(n-1) - '0';
    }
}
