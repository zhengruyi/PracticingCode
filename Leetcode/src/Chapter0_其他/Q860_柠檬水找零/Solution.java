package Chapter0_其他.Q860_柠檬水找零;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 17/12/2020 22:33
 **/

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        /**
         * 题目简单，唯一要考虑的是在收到20时优先用10块找零，因为10块只有这里一个用途，
         * 5块还会用在其他地方
         */
        int[] coins = new int[3];
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                coins[0]++;
            }else if(bills[i] == 10){
                if(coins[0] == 0){
                    return false;
                }else{
                    coins[1]++;
                    coins[0]--;
                }
            }else{
                if(coins[1] > 0 && coins[0] > 0){
                    coins[2]++;
                    coins[1]--;
                    coins[0]--;
                }else if(coins[0] >= 3){
                    coins[0] -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
