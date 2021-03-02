package Chapter0_其他.Q441_排列硬币;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 02/03/2021 23:29
 **/

public class Solution {
    public int arrangeCoins(int n) {
        if(n < 1){
            return 0;
        }
        long res = 1;
        while(res * (1+ res) <= 2 * (long)n){
            res++;
        }
        return (int)(res - 1);
    }
}
