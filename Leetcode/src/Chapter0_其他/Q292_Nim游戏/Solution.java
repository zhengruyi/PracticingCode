package Chapter0_其他.Q292_Nim游戏;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 26/10/2020 12:43
 **/

public class Solution {
    public boolean canWinNim(int n) {
        //重要不被4整除，最终都可以获胜
        if( n % 4 != 0){
            return  true;
        }
        return false;
    }
}
