package Chapter0_其他.Q357_计算各个位数不同的数字个数;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 25/12/2020 23:26
 **/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        int sum = 1;
        int times = 9;
        for(int j = 1; j <= n; j++){
            for(int i = 1; i < j; i++){
                //两位数的情况为 9(1-9) * 9(0 + 1-9中筛去第一个数字)
                //三位数为9*9*8
                //四位数 9*9*8*7
                times *= (10 - i);
            }
            //总数目是各个位数的数字的和
            sum += times;
            times = 9;
        }

        return sum;
    }
}
