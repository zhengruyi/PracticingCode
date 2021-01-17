package Chapter0_其他.Q397_整数替换;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/01/2021 21:01
 **/

public class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;
        while(num > 1){
            //偶数直接移位
            if(num % 2 == 0){
                num >>= 1;
            }else{
                //奇数时分为两种情况01或者11,01这种情况减去1就可以持续右移两次
                //11这种情况则可以通过+1来把末尾全部变成0，然后持续移位
                num += (num & 2) == 0 || num == 3 ? -1 : 1;
            }
            //统计转换次数
            count++;
        }
        return count;
    }
}
